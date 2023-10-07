package org.coursework.model;

import javax.print.DocFlavor;

public class UserExtended extends User {
    Integer id;
    Integer is_ldap_user;
    String google_id;
    String github_id;
    Integer notifications_enabled;
    String timezone;
    String language;
    Integer disable_login_form;
    Integer twofactor_activated;
    String twofactor_secret;
    String token;
    Integer notifications_filter;
    Integer nb_failed_login;
    Integer lock_expiration_date;
    Integer gitlab_id;
    Integer is_active;
    String avatar_path;
    String api_access_token;
    String filter;
    String theme;

    public UserExtended() {
    }

    public UserExtended(String username, String password, String name, String email, String role) {
        super(username, password, name, email, role);
    }

    public UserExtended(Integer id,
                        String username,
                        String password,
                        Integer is_ldap_user,
                        String name,
                        String email,
                        String google_id,
                        String github_id,
                        Integer notifications_enabled,
                        String timezone,
                        String language,
                        Integer disable_login_form,
                        Integer twofactor_activated,
                        String twofactor_secret,
                        String token,
                        Integer notifications_filter,
                        Integer nb_failed_login,
                        Integer lock_expiration_date,
                        Integer gitlab_id,
                        String role,
                        Integer is_active,
                        String avatar_path,
                        String api_access_token,
                        String filter,
                        String theme) {
        super(username, password, name, email, role);
        this.id = id;
        this.is_ldap_user = is_ldap_user;
        this.google_id = google_id;
        this.github_id = github_id;
        this.notifications_enabled = notifications_enabled;
        this.timezone = timezone;
        this.language = language;
        this.disable_login_form = disable_login_form;
        this.twofactor_activated = twofactor_activated;
        this.twofactor_secret = twofactor_secret;
        this.token = token;
        this.notifications_filter = notifications_filter;
        this.nb_failed_login = nb_failed_login;
        this.lock_expiration_date = lock_expiration_date;
        this.gitlab_id = gitlab_id;
        this.is_active = is_active;
        this.avatar_path = avatar_path;
        this.api_access_token = api_access_token;
        this.filter = filter;
        this.theme = theme;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIs_ldap_user() {
        return is_ldap_user;
    }

    public String getGoogle_id() {
        return google_id;
    }

    public String getGithub_id() {
        return github_id;
    }

    public Integer getNotifications_enabled() {
        return notifications_enabled;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getLanguage() {
        return language;
    }

    public Integer getDisable_login_form() {
        return disable_login_form;
    }

    public Integer getTwofactor_activated() {
        return twofactor_activated;
    }

    public String getTwofactor_secret() {
        return twofactor_secret;
    }

    public String getToken() {
        return token;
    }

    public Integer getNotifications_filter() {
        return notifications_filter;
    }

    public Integer getNb_failed_login() {
        return nb_failed_login;
    }

    public Integer getLock_expiration_date() {
        return lock_expiration_date;
    }

    public Integer getGitlab_id() {
        return gitlab_id;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public String getAvatar_path() {
        return avatar_path;
    }

    public String getApi_access_token() {
        return api_access_token;
    }

    public String getFilter() {
        return filter;
    }

    public String getTheme() {
        return theme;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIs_ldap_user(Integer is_ldap_user) {
        this.is_ldap_user = is_ldap_user;
    }

    public void setGoogle_id(String google_id) {
        this.google_id = google_id;
    }

    public void setGithub_id(String github_id) {
        this.github_id = github_id;
    }

    public void setNotifications_enabled(Integer notifications_enabled) {
        this.notifications_enabled = notifications_enabled;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setDisable_login_form(Integer disable_login_form) {
        this.disable_login_form = disable_login_form;
    }

    public void setTwofactor_activated(Integer twofactor_activated) {
        this.twofactor_activated = twofactor_activated;
    }

    public void setTwofactor_secret(String twofactor_secret) {
        this.twofactor_secret = twofactor_secret;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setNotifications_filter(Integer notifications_filter) {
        this.notifications_filter = notifications_filter;
    }

    public void setNb_failed_login(Integer nb_failed_login) {
        this.nb_failed_login = nb_failed_login;
    }

    public void setLock_expiration_date(Integer lock_expiration_date) {
        this.lock_expiration_date = lock_expiration_date;
    }

    public void setGitlab_id(Integer gitlab_id) {
        this.gitlab_id = gitlab_id;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }

    public void setAvatar_path(String avatar_path) {
        this.avatar_path = avatar_path;
    }

    public void setApi_access_token(String api_access_token) {
        this.api_access_token = api_access_token;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
