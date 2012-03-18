package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import models.Account;
import models.Location;
import play.mvc.Controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Application extends Controller {

    public static void index() {

        Account acct = Account.findById(new Long(1));
//
        Location loc = new Location();
        loc.longitude = new BigDecimal(99.99);
        loc.latitude = new BigDecimal(34.11);
        loc.account = acct;


        loc.save();

//        System.out.println("account is what? " + acct);


//        Account acctn = new Account();
//        acctn.name = "Billy Shears";
//        acctn.save();

        System.out.println("done?");
//        acctn.
        render();
    }


    public static void saveLocation(String id, JsonObject body) throws Exception {
        String eventname = body.getAsJsonPrimitive("name").getAsString();
        double latitude = body.getAsJsonPrimitive("latitude").getAsDouble();
        double longitude = body.getAsJsonPrimitive("longitude").getAsDouble();

        Location loc = new Location();
        loc.longitude = new BigDecimal(longitude);
        loc.latitude = new BigDecimal(latitude);
        loc.name = eventname;
        loc.account = Account.findById(new Long(id));

        loc.save();

        renderJSON(getSuccessMessage());
    }

    private static String getSuccessMessage() {
        Map mp = new HashMap<String, String>();
        mp.put("status", "success");
        return new Gson().toJson(mp);
    }


}