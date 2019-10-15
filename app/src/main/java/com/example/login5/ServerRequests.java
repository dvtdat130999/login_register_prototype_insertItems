/*
package com.example.login5;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.http.HttpResponseCache;
import android.os.AsyncTask;

import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;

public class ServerRequests {
    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT=1000*15;
    public static final String SERVER_ADDRESS="";

    public ServerRequests(Context context)
    {
        progressDialog=new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait...");

    }

    public void storeUserDataInBackground(User user,GetUserCallback userCallback)
    {
        progressDialog.show();
        new StoreUserDataAsyncTask(user,userCallback).execute();
    }

    public void fetchUserDataInBackground(User user,GetUserCallback userCallback)
    {
        progressDialog.show();
        new fetchUserDataAsyncTask(user,userCallback).execute();
    }

    public class StoreUserDataAsyncTask extends AsyncTask<Void,Void,Void>{
        User user;
        GetUserCallback userCallback;

        public StoreUserDataAsyncTask(User user,GetUserCallback userCallback){
            this.user=user;
            this.userCallback=userCallback;
        }
        @Override
        protected Void doInBackground(Void... params)
        {

            ArrayList<NameValuePair> dataToSend=new ArrayList<>();
            dataToSend.add(new BasicNameValuePair("firstName",user.firstName));
            dataToSend.add(new BasicNameValuePair("lastName",user.lastName));
            dataToSend.add(new BasicNameValuePair("username",user.username));
            dataToSend.add(new BasicNameValuePair("password",user.password));
            dataToSend.add(new BasicNameValuePair("phone",user.phone));
            dataToSend.add(new BasicNameValuePair("address",user.address));
            dataToSend.add(new BasicNameValuePair("birthDate",user.birthDate));
            dataToSend.add(new BasicNameValuePair("userType",user.userType));


            HttpParams httpRequestParams=new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams,CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams,CONNECTION_TIMEOUT);

            HttpClient client=new DefaultHttpClient(httpRequestParams);
            HttpPost post=new HttpPost(SERVER_ADDRESS+"Register.php");

            try{
                post.setEntity(new UrlEncodedFormEntity(dataToSend));
                client.execute(post);

            }catch (Exception e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            progressDialog.dismiss();
            userCallback.done(null);
            super.onPostExecute(aVoid);
        }
    }
    public class fetchUserDataAsyncTask extends AsyncTask<Void,Void,User> {
        User user;
        GetUserCallback userCallback;

        public fetchUserDataAsyncTask(User user, GetUserCallback userCallback) {
            this.user = user;
            this.userCallback = userCallback;
        }

        @Override
        protected User doInBackground(Void... voids) {
            ArrayList<NameValuePair> dataToSend=new ArrayList<>();

            dataToSend.add(new BasicNameValuePair("username",user.username));
            dataToSend.add(new BasicNameValuePair("password",user.password));

            HttpParams httpRequestParams=new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams,CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams,CONNECTION_TIMEOUT);

            HttpClient client=new DefaultHttpClient(httpRequestParams);
            HttpPost post=new HttpPost(SERVER_ADDRESS+"FetchUserData.php");

            User returnedUser =null;
            try{
                post.setEntity(new UrlEncodedFormEntity(dataToSend));
                HttpResponse httpResponse =client.execute(post);

                HttpEntity entity=httpResponse.getEntity();
                String result=EntityUtils.toString(entity);
                JSONObject jsonObject=new JSONObject(result);

                if(jsonObject.length()!=0)
                {
                    returnedUser=null;

                }
                else
                {
                    String firstName=jsonObject.getString("firstName");
                    String lastName=jsonObject.getString("lastName");
                    String birthDate=jsonObject.getString("birthDate");
                    String phone=jsonObject.getString("phone");
                    String address=jsonObject.getString("address");
                    String userType=jsonObject.getString("userType");

                    returnedUser=new User(firstName,lastName,user.username,user.password,phone,address,birthDate,userType);

                }


            }catch (Exception e)
            {
                e.printStackTrace();
            }

            return returnedUser;
        }
        @Override
        protected void onPostExecute(User returnedUser) {

            progressDialog.dismiss();
            userCallback.done(returnedUser);
            super.onPostExecute(returnedUser);
        }
    }
}
*/
