package com.example.demo189.entity;

public class Mail {
    private Language language = Language.English;
    private int pageSize = 25;
    private boolean spamFilter;
    private String signature;

    public Language getLanguage() { return language; }
    public void setLanguage(Language language) { this.language = language; }
    public int getPageSize() { return pageSize; }
    public void setPageSize(int pageSize) { this.pageSize = pageSize; }
    public boolean isSpamFilter() { return spamFilter; }
    public void setSpamFilter(boolean spamFilter) { this.spamFilter = spamFilter; }
    public String getSignature() { return signature; }
    public void setSignature(String signature) { this.signature = signature; }
}
