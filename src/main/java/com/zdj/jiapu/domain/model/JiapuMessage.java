package com.zdj.jiapu.domain.model;

import java.util.Date;

public class JiapuMessage {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jiapumessage.messageid
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    private Integer messageid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jiapumessage.createDate
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    private Date createdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jiapumessage.message
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    private String message;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jiapumessage.senderid
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    private String senderid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jiapumessage.recieverid
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    private String recieverid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jiapumessage.messageid
     *
     * @return the value of jiapumessage.messageid
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public Integer getMessageid() {
        return messageid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jiapumessage.messageid
     *
     * @param messageid the value for jiapumessage.messageid
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jiapumessage.createDate
     *
     * @return the value of jiapumessage.createDate
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jiapumessage.createDate
     *
     * @param createdate the value for jiapumessage.createDate
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jiapumessage.message
     *
     * @return the value of jiapumessage.message
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jiapumessage.message
     *
     * @param message the value for jiapumessage.message
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jiapumessage.senderid
     *
     * @return the value of jiapumessage.senderid
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public String getSenderid() {
        return senderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jiapumessage.senderid
     *
     * @param senderid the value for jiapumessage.senderid
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public void setSenderid(String senderid) {
        this.senderid = senderid == null ? null : senderid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jiapumessage.recieverid
     *
     * @return the value of jiapumessage.recieverid
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public String getRecieverid() {
        return recieverid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jiapumessage.recieverid
     *
     * @param recieverid the value for jiapumessage.recieverid
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public void setRecieverid(String recieverid) {
        this.recieverid = recieverid == null ? null : recieverid.trim();
    }
}