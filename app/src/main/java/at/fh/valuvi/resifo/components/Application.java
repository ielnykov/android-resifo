package at.fh.valuvi.resifo.components;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import java.util.ArrayList;
import java.util.HashMap;
import at.fh.valuvi.resifo.helpers.ArrayHelper;

public class Application extends android.app.Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getAppContext() {
        return context;
    }

    public static void showValidationAlert(HashMap<String, String> errors, Context context) {

        ArrayList<String> errorMsgList = new ArrayList<>();
        for (String error: errors.values()) { errorMsgList.add("- " + error); }

        String errorMsg = "Validation went wrong! Please check your provided data:\n\n" +
                (new ArrayHelper(errorMsgList)).join("\n");

        new AlertDialog.Builder(context)
                .setTitle("Validation error")
                .setMessage(errorMsg)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete

                    }
                })
//                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        // do nothing
//                    }
//                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public static void showAlert(String message, String title, Context context) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {}
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}