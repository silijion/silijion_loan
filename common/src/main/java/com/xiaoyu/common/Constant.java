package com.xiaoyu.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart@create 2019-09-22 20:55
 */
public class Constant {

    public static final String SEQUENCE_LOAN = "seq_loan";

    public static final String SYSTEM_ID = "systemId";

    public static final String SYSTEM_NAME = "systemName";


    public static class DataStatus{
        //有效
        public static final int VALID = 1;

        //无效
        public static final int INVALID = 0;


        public static final String getName( int type ) {
            String returnName = "";
            switch( type ) {
                case VALID:
                    returnName = "有效";
                    break;
                case INVALID:
                    returnName = "无效";
                    break;
                default:break;
            }
            return returnName;
        }

        public static List<ComboEntity> getList() {
            List<ComboEntity> list = new ArrayList<>();
            list.add( new ComboEntity( getName( VALID ), String.valueOf( VALID ) ) );
            list.add( new ComboEntity( getName( INVALID ), String.valueOf( INVALID ) ) );
            return list;
        }

    }


    public static class Gender{

        //男
        public static final int BOY = 1;

        //女
        public static final int GIRL = 2;

        public static final String getName( int type ) {
            String returnName = "";
            switch( type ) {
                case BOY:
                    returnName = "男";
                    break;
                case GIRL:
                    returnName = "女";
                    break;
                default:break;
            }
            return returnName;
        }

        public static List<ComboEntity> getList() {

            List<ComboEntity> list = new ArrayList<>();
            list.add( new ComboEntity( getName( BOY ), String.valueOf( BOY ) ) );
            list.add( new ComboEntity( getName( GIRL ), String.valueOf( GIRL ) ) );
            return list;
        }

    }

}
