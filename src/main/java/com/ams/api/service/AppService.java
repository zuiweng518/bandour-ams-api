package com.ams.api.service;

import com.ams.api.entity.App;

public interface AppService {
    App findApp(String app_code,String app_secret,String domains);
}
