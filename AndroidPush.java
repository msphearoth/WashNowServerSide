import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AndroidPush {

    /**
     * Replace SERVER_KEY with your SERVER_KEY generated from FCM
     * Replace DEVICE_TOKEN with your DEVICE_TOKEN
     */
    private static String SERVER_KEY = "AAAALeaeZMA:APA91bGJx-0cl0tNdbbsDzajliuKwqRCSPEIu5E7mcU8vNkExQyxmfb7f0zXyyjBCe6EEXwESFgnWAtPntwkRyhSJe3QNDb4hsN_QwY_9CkSoynPmg6Sx5f0AYwd3nKJLBhBactSFAU9";
    //private static String DEVICE_TOKEN = "eUo-JbGR3BY:APA91bH0fOGGp-mmyfFrefl6SZIuWRL4gb8vnGh_zvTi5uHylFfTo_qPuwYb17F_pDNo6NQn3z8V8tydHYL4XPSRJRrJ2Nb9F1ZojIJorKxPnstoDaZjnWgNhICIi4Si1BWKXAXtC5dK";
    private static String DEVICE_TOKEN = "dyozJSKNjME:APA91bGayCWyKf76UJM2uqCXbbAhLAJGG2k-bWV_R7Bgnttu5LkVVs2Jt_Ijk9ox-T3LgJ8tlqfx2QveLM7UCJoOc9tQSubNw1hUp99n4DZ_bhcuFM7q2DBVBRtsmIzAaggviAqytDyk";

    /**
     * USE THIS METHOD to send push notification
     */
    public static void main(String[] args) throws Exception {
        String title = "WashNow";
        String message = "Washers are available now. It's laundry time :)";
        sendPushNotification(title, message);
    }


    /**
     * Sends notification to mobile, YOU DON'T NEED TO UNDERSTAND THIS METHOD
     */
    private static void sendPushNotification(String title, String message) throws Exception {
        String pushMessage = "{\"data\":{\"title\":\"" +
                title +
                "\",\"message\":\"" +
                message +
                "\"},\"to\":\"" +
                DEVICE_TOKEN +
                "\"}";
        // Create connection to send FCM Message request.
        URL url = new URL("https://fcm.googleapis.com/fcm/send");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Authorization", "key=" + SERVER_KEY);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        // Send FCM message content.
        OutputStream outputStream = conn.getOutputStream();
        outputStream.write(pushMessage.getBytes());

        System.out.println(conn.getResponseCode());
        System.out.println(conn.getResponseMessage());
    }
}
