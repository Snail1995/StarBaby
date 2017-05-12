package com.xiaofeng.startbaby.model;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by XIAOHONG
 * Author: XIAOHONG.
 * Date: 2017/5/13.
 */

public class CommunityInfo {
    @SerializedName("list")
    private List<CommunityBoard> list;

    public List<CommunityBoard> getList() {
        return list;
    }

    public void setList(List<CommunityBoard> list) {
        this.list = list;
    }

    public static class CommunityBoard {
        @SerializedName("board_category_name")
        private String board_category_name;
        @SerializedName("board_list")
        private List<CommunityInfoImpl> board_list;

        public String getBoard_category_name() {
            return board_category_name;
        }

        public void setBoard_category_name(String board_category_name) {
            this.board_category_name = board_category_name;
        }

        public List<CommunityInfoImpl> getBoard_list() {
            return board_list;
        }

        public void setBoard_list(List<CommunityInfoImpl> board_list) {
            this.board_list = board_list;
        }
    }


    public static class CommunityInfoImpl {
        @SerializedName("board_img")
        private String board_img;
        @SerializedName("board_name")
        private String board_name;
        @SerializedName("favNum")
        private int favNum;

        public String getBoard_img() {
            return board_img;
        }

        public void setBoard_img(String board_img) {
            this.board_img = board_img;
        }

        public String getBoard_name() {
            return board_name;
        }

        public void setBoard_name(String board_name) {
            this.board_name = board_name;
        }

        public int getFavNum() {
            return favNum;
        }

        public void setFavNum(int favNum) {
            this.favNum = favNum;
        }
    }


}
