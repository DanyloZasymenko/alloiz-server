package com.alloiz.alloizserver.service;

import com.alloiz.alloizserver.model.Callback;

public interface MailService {

    Callback sendCallback(Callback callback);
}
