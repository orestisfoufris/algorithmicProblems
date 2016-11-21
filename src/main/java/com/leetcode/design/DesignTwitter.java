package com.leetcode.design;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.com/problems/design-twitter/
 * 21/11/2016.
 */
public class DesignTwitter {

    private AtomicInteger clock = new AtomicInteger();
    private Map<Integer, TwitterUser> users;

    public DesignTwitter() {
        users = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            TwitterUser u = new TwitterUser(userId);
            users.put(userId, u);
        }
        users.get(userId).postNewTweet(tweetId);

    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new LinkedList<>();

        if (!users.containsKey(userId)) {
            return result;
        }

        Set<Integer> following = users.get(userId).following;
        PriorityQueue<Tweet> queue = new PriorityQueue<>(following.size(), (a, b) -> (b.time - a.time));

        for (int user : following) {
            Tweet tweetHead = users.get(user).tweetHead;
            if (tweetHead != null) {
                queue.add(tweetHead);
            }
        }

        int counter = 0;
        while (!queue.isEmpty() && counter < 10) {
            Tweet tweet = queue.poll();
            result.add(tweet.userId);
            counter++;

            if (tweet.next != null) {
                queue.add(tweet.next);
            }
        }

        return result;

    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            TwitterUser user = new TwitterUser(followerId);
            users.put(followerId, user);
        }

        if (!users.containsKey(followeeId)) {
            TwitterUser u = new TwitterUser(followeeId);
            users.put(followeeId, u);
        }

        users.get(followerId).follow(followeeId);
    }


    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId) && followerId != followeeId) {
            users.get(followerId).unfollow(followeeId);
        }
    }

    private class Tweet {
        final int userId;
        final int time;
        Tweet next;

        Tweet(int userId) {
            this.userId = userId;
            time = clock.getAndIncrement();
            next = null;
        }
    }

    private class TwitterUser {
        final int userId;
        final Set<Integer> following;
        Tweet tweetHead;

        TwitterUser(int userId) {
            this.userId = userId;
            following = new HashSet<>();
            following.add(userId);

            tweetHead = null;
        }

        void follow(int userId) {
            following.add(userId);
        }

        void unfollow(int userId) {
            following.remove(userId);
        }

        void postNewTweet(int userId) {
            Tweet tweet = new Tweet(userId);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }
}