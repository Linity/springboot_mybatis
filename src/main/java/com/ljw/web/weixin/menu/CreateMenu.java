package com.ljw.web.weixin.menu;

/**
 * Created by Linity on 2017/3/8.
 */
public class CreateMenu {
    private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    private static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    public static Menu initMenu(){
        Menu menu = new Menu();

        Button button11 = new Button();
//        button11.setKey("11");
        button11.setName("IT推文");
//        button11.setType("click");

        ClickButton button12 = new ClickButton();
        button12.setKey("12");
        button12.setName("热门文章");
        button12.setType("click");
        button11.setSub_button(new Button[]{button12});

        Button button21 = new Button();
//        button21.setType("view");
        button21.setName("NBA");
//        button21.setKey("21");

        ViewButton button22 = new ViewButton();
        button22.setName("Stephen Curry");
        button22.setType("view");
        button22.setUrl("http://nba.stats.qq.com/player/?id=4612");

        ViewButton button23 = new ViewButton();
        button23.setName("今日赛况");
        button23.setType("view");
        button23.setUrl("http://sports.qq.com/nba/");//微信会check url是否有效
        button21.setSub_button(new Button[]{button22,button23});

        Button button31 = new Button();
//        button31.setKey("31");
//        button31.setType("click");
        button31.setName("About me");

        ClickButton button32 = new ClickButton();
        button32.setKey("32");
        button32.setName("个人介绍");
        button32.setType("click");

        button31.setSub_button(new Button[]{button32});

        menu.setButton(new Button[]{button11,button21,button31});

        return menu;
    }

//    public static int postMenu(String token,String menu) throws IOException {
//        int result = 0;
//        String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
//        JSONObject jsonObject = WeixinUtil.doPostStr(url, menu);
//        if(jsonObject != null){
//            result = jsonObject.getIntValue("errcode");
//        }
//        return result;
//    }
//
//    public static int deleteMenu(String token) throws ParseException, IOException{
//        String url = DELETE_MENU_URL.replace("ACCESS_TOKEN", token);
//        JSONObject jsonObject = WeixinUtil.doGetStr(url);
//        int result = 0;
//        if(jsonObject != null){
//            result = jsonObject.getIntValue("errcode");
//        }
//        return result;
//    }
}
