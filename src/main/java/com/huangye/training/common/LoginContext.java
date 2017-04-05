package com.huangye.training.common;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;

/**
 * Created by huangye on 2017/3/30.
 */
public class LoginContext {
    private static final ThreadLocal<LoginContext> holder = new ThreadLocal();
    private static final Log log = LogFactory.getLog(LoginContext.class);
    private long userId;
    private String pin;
    private String nick;
    private int checksum;
    private long created = System.currentTimeMillis();
    private long expires;
    private boolean persistent;

    public LoginContext() {
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getNick() {
        return this.nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public static void setLoginContext(LoginContext loginContext) {
        holder.set(loginContext);
    }

    public static LoginContext getLoginContext() {
        return (LoginContext)holder.get();
    }

    public static void remove() {
        holder.remove();
    }

    public static LoginContext parse(String value) {
        LoginContext context = new LoginContext();
        return context;
    }

    public boolean getLogin() {
        return this.isLogin();
    }

    public boolean isLogin() {
        return StringUtils.isNotBlank(this.pin);
    }

    public void setChecksum(int checksum) {
        this.checksum = checksum;
    }

    public int getChecksum() {
        return this.checksum;
    }

    public long getCreated() {
        return this.created;
    }

    public Date getCreatedDate() {
        return new Date(this.created);
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public void setCreatedDate(Date created) {
        this.created = created.getTime();
    }

    public void setCreated() {
        this.created = System.currentTimeMillis();
    }

    public long getExpires() {
        return this.expires;
    }

    public Date getExpiresDate() {
        return new Date(this.expires);
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public void setExpiresDate(Date expires) {
        this.expires = expires.getTime();
    }

    public void setTimeout(long timeout) {
        this.expires = this.created + timeout;
    }

    public boolean isPersistent() {
        return this.persistent;
    }

    public void setPersistent(boolean persistent) {
        this.persistent = persistent;
    }
}
