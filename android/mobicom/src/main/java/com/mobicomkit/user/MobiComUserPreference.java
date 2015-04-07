package com.mobicomkit.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import net.mobitexter.mobiframework.commons.core.utils.ContactNumberUtils;

import java.util.Date;



public class MobiComUserPreference {

    private Context context;
    private String countryCode;
    public static MobiComUserPreference userpref;
    public SharedPreferences sharedPreferences;

    //Constants for preferneces ..
    private static String device_registration_id="device_registration_id";
    private static String device_key_string="device_key_string";
    private static String last_outbox_sync_time="last_outbox_sync_time";
    private static String delivery_report_pref_key="delivery_report_pref_key";
    private static String last_inbox_sync_time="last_inbox_sync_time";
    private static String last_message_stat_sync_time="last_message_stat_sync_time";
    private static String sent_sms_sync_pref_key="sent_sms_sync_pref_key";
    private static String email="email";
    private static String email_verified="email_verified";
    private static String user_key_string="user_key_string";
    private static String stop_service="stop_service";
    private static String patch_available="patch_available";
    private static String webhook_enable_key="webhook_enable_key";
    private static String group_sms_freq_key="group_sms_freq_key";
    private static String update_push_registration="update_push_registration";
    private static String verify_contact_number="verify_contact_number";
    private static String received_sms_sync_pref_key="received_sms_sync_pref_key";
    private static String phone_number_key="phone_number_key";
    private static String call_history_display_within_messages_pref_key="call_history_display_within_messages_pref_key";
    private static String mobitexter_contact_sync_key="mobitexter_contact_sync_key";
    private static String last_sms_sync_time="last_sms_sync_time";



    private MobiComUserPreference(Context context) {
        this.context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        initialize(context);
    }

    public static MobiComUserPreference getInstance(Context context) {
        if (userpref == null) {
            userpref = new MobiComUserPreference(context);
        }
        return userpref;
    }

    /*
    public void setDeviceRegistrationId(String deviceRegistrationId) {
        sharedPreferences.edit().putString(OsuConstants.DEVICE_REGISTRATION_ID, deviceRegistrationId).commit();
    }

    public String getDeviceRegistrationId() {
        return sharedPreferences.getString(OsuConstants.DEVICE_REGISTRATION_ID, null);
    }*/

    public boolean isRegistered() {
        return !TextUtils.isEmpty(getDeviceKeyString());
    }

    public void setDeviceRegistrationId(String deviceRegistrationId) {
        sharedPreferences.edit().putString(device_registration_id, deviceRegistrationId).commit();
    }

    public String getDeviceRegistrationId() {
        return sharedPreferences.getString(device_registration_id, null);
    }

    public void setDeviceKeyString(String deviceKeyString) {
        sharedPreferences.edit().putString(device_key_string, deviceKeyString).commit();
    }

    public String getDeviceKeyString() {
        return sharedPreferences.getString(device_key_string, null);
    }

    public long getLastOutboxSyncTime() {
        return sharedPreferences.getLong(last_outbox_sync_time, 0L);
    }

    public void setLastOutboxSyncTime(long lastOutboxSyncTime) {
        sharedPreferences.edit().putLong(last_outbox_sync_time, lastOutboxSyncTime).commit();
    }

    public void setLastSyncTime(String lastSyncTime) {
        sharedPreferences.edit().putString(last_sms_sync_time, lastSyncTime).commit();
    }

    public boolean isReportEnable() {
        return sharedPreferences.getBoolean(delivery_report_pref_key, false);
    }

    public void setReportEnable(boolean  reportEnable) {
        sharedPreferences.edit().putBoolean(delivery_report_pref_key,reportEnable).commit();
    }

    public String getLastSyncTime() {
        return sharedPreferences.getString(last_sms_sync_time, "0");
    }

    public long getLastInboxSyncTime() {
        return sharedPreferences.getLong(last_sms_sync_time, 0L);
    }

    public void setLastInboxSyncTime(long lastInboxSyncTime) {
        sharedPreferences.edit().putLong(last_inbox_sync_time, lastInboxSyncTime).commit();
    }

    public void setLastMessageStatSyncTime(long lastMessageStatSyncTime) {
        sharedPreferences.edit().putLong(last_message_stat_sync_time, lastMessageStatSyncTime).commit();
    }

    public Long getLastMessageStatSyncTime() {
        return sharedPreferences.getLong(last_message_stat_sync_time, 0);
    }

    public boolean isSentSmsSyncFlag() {
        return sharedPreferences.getBoolean(sent_sms_sync_pref_key, true);
    }

    public void setSentSmsSyncFlag(boolean sentSmsSyncFlag) {
        sharedPreferences.edit().putBoolean(sent_sms_sync_pref_key, sentSmsSyncFlag).commit();
    }

    public void setEmailIdValue(String emailIdValue) {
        sharedPreferences.edit().putString(email, emailIdValue).commit();
    }

    public String getEmailIdValue() {
        return sharedPreferences.getString(email, null);
    }

    public void setEmailVerified(boolean emailVerified) {
        sharedPreferences.edit().putBoolean(email_verified, emailVerified).commit();
    }

    public boolean isEmailVerified() {
        return sharedPreferences.getBoolean(email_verified, true);
    }

    public void setSuUserKeyString(String suUserKeyString) {
        sharedPreferences.edit().putString(user_key_string, suUserKeyString).commit();
    }

    public String getSuUserKeyString() {
        return sharedPreferences.getString(user_key_string, null);
    }

    public void setStopServiceFlag(Boolean stopServiceFlag) {
        sharedPreferences.edit().putBoolean(stop_service, stopServiceFlag).commit();
    }

    public boolean isStopServiceFlag() {
        return sharedPreferences.getBoolean(stop_service, false);
    }

    public void setPatchAvailable(Boolean patchAvailable) {
        sharedPreferences.edit().putBoolean(patch_available, patchAvailable).commit();
    }

    public boolean isPatchAvailable() {
        return sharedPreferences.getBoolean(patch_available, false);
    }

    public boolean isWebHookEnable(){
        return sharedPreferences.getBoolean(webhook_enable_key, false);
    }

    public void setWebHookEnable(boolean enable){
        sharedPreferences.edit().putBoolean(webhook_enable_key, enable).commit();
    }

    public int getGroupSmsDelayInSec(){
        return sharedPreferences.getInt(group_sms_freq_key, 0);
    }

    public void setDelayGroupSmsDelayTime(int delay) {
        sharedPreferences.edit().
                putInt(group_sms_freq_key,delay).commit();
    }


//    public boolean getNewPatchAvailable() {
//        return newPatchAvailable;
//    }
//
//    public boolean getUpdateRegFlag() {
//        return updateRegFlag;
//    }

    public void setUpdateRegFlag(boolean updateRegFlag) {
        sharedPreferences.edit().putBoolean(update_push_registration, updateRegFlag).commit();
    }

    public boolean isUpdateRegFlag() {
        return sharedPreferences.getBoolean(update_push_registration, false);
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isVerifyContactNumber() {
        return sharedPreferences.getBoolean(verify_contact_number, false);
    }

    public void setVerifyContactNumber(boolean verifyContactNumber) {
        sharedPreferences.edit().putBoolean(verify_contact_number, verifyContactNumber).commit();
    }

    public boolean getReceivedSmsSyncFlag() {
        return sharedPreferences.getBoolean(received_sms_sync_pref_key, true);
    }

    public void setReceivedSmsSyncFlag(boolean receivedSmsSyncFlag) {
        sharedPreferences.edit().putBoolean(received_sms_sync_pref_key, receivedSmsSyncFlag).commit();
    }

    public String getContactNumber() {
        return sharedPreferences.getString(phone_number_key, null);
    }

    public void setContactNumber(String contactNumber) {
        contactNumber = ContactNumberUtils.getPhoneNumber(contactNumber, getCountryCode());
        sharedPreferences.edit().putString(phone_number_key, contactNumber).commit();
    }

    public boolean isDisplayCallRecordEnable() {
        return sharedPreferences.getBoolean(call_history_display_within_messages_pref_key, false);
    }

    public void setDisplayCallRecordEnable(boolean enable) {
        sharedPreferences.edit().putBoolean(call_history_display_within_messages_pref_key, enable).commit();
    }

    //Local initialization of few fields
    public void initialize(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String countryCode = telephonyManager.getSimCountryIso().toUpperCase();
        String contactNumber = telephonyManager.getLine1Number();
        setCountryCode(countryCode);
        if (!TextUtils.isEmpty(contactNumber)) {
            setContactNumber(contactNumber);
        }
        if (getLastMessageStatSyncTime() == null || getLastMessageStatSyncTime() == 0) {
            setLastMessageStatSyncTime(new Date().getTime());
        }
    }

    public void setMobiTexterContactSyncCompleted(boolean status) {
        sharedPreferences.edit().
        putBoolean(mobitexter_contact_sync_key, status).commit();
    }

    public boolean isMobiTexterContactSyncCompleted() {
        return sharedPreferences.getBoolean(mobitexter_contact_sync_key, false);
    }

    @Override
    public String toString() {
        return "MobiComUserPreference{" +
                "context=" + context +
                ", countryCode='" + getCountryCode() + '\'' +
                ", deviceKeyString=" + getDeviceKeyString() +
                ", contactNumber=" + getContactNumber() +
                '}';
    }
}