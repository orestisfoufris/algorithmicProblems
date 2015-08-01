package com.topcoder.div2.levelOne;

/**
 * Created by Orestis on 01/08/2015
 * Problem statement: http://community.topcoder.com/stat?c=problem_statement&pm=12335&rd=15486
 */
public class PenguinTiles {

    public static int minMoves(String[] tiles) {

        if (tiles[tiles.length - 1].charAt(tiles[0].length() - 1) == '.') {
            return 0;
        }

        int emptyTilePos = 0;
        int foundOn = 0;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length(); j++) {
                if (tiles[i].charAt(j) == '.') {
                    emptyTilePos = j;
                    foundOn = i;
                }
            }
        }

        if (emptyTilePos == tiles[0].length() - 1 || foundOn == tiles.length - 1) {
            return 1;
        }

        return 2;
    }
}
