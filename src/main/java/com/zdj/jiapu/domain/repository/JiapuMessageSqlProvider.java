package com.zdj.jiapu.domain.repository;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.zdj.jiapu.domain.model.JiapuMessage;
import com.zdj.jiapu.domain.model.JiapuMessageExample.Criteria;
import com.zdj.jiapu.domain.model.JiapuMessageExample.Criterion;
import com.zdj.jiapu.domain.model.JiapuMessageExample;
import java.util.List;
import java.util.Map;

public class JiapuMessageSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jiapumessage
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public String countByExample(JiapuMessageExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("jiapumessage");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jiapumessage
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public String deleteByExample(JiapuMessageExample example) {
        BEGIN();
        DELETE_FROM("jiapumessage");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jiapumessage
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public String insertSelective(JiapuMessage record) {
        BEGIN();
        INSERT_INTO("jiapumessage");
        
        if (record.getMessageid() != null) {
            VALUES("messageid", "#{messageid,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedate() != null) {
            VALUES("createDate", "#{createdate,jdbcType=DATE}");
        }
        
        if (record.getMessage() != null) {
            VALUES("message", "#{message,jdbcType=VARCHAR}");
        }
        
        if (record.getSenderid() != null) {
            VALUES("senderid", "#{senderid,jdbcType=VARCHAR}");
        }
        
        if (record.getRecieverid() != null) {
            VALUES("recieverid", "#{recieverid,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jiapumessage
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public String selectByExample(JiapuMessageExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("messageid");
        } else {
            SELECT("messageid");
        }
        SELECT("createDate");
        SELECT("message");
        SELECT("senderid");
        SELECT("recieverid");
        FROM("jiapumessage");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jiapumessage
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        JiapuMessage record = (JiapuMessage) parameter.get("record");
        JiapuMessageExample example = (JiapuMessageExample) parameter.get("example");
        
        BEGIN();
        UPDATE("jiapumessage");
        
        if (record.getMessageid() != null) {
            SET("messageid = #{record.messageid,jdbcType=INTEGER}");
        }
        
        if (record.getCreatedate() != null) {
            SET("createDate = #{record.createdate,jdbcType=DATE}");
        }
        
        if (record.getMessage() != null) {
            SET("message = #{record.message,jdbcType=VARCHAR}");
        }
        
        if (record.getSenderid() != null) {
            SET("senderid = #{record.senderid,jdbcType=VARCHAR}");
        }
        
        if (record.getRecieverid() != null) {
            SET("recieverid = #{record.recieverid,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jiapumessage
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("jiapumessage");
        
        SET("messageid = #{record.messageid,jdbcType=INTEGER}");
        SET("createDate = #{record.createdate,jdbcType=DATE}");
        SET("message = #{record.message,jdbcType=VARCHAR}");
        SET("senderid = #{record.senderid,jdbcType=VARCHAR}");
        SET("recieverid = #{record.recieverid,jdbcType=VARCHAR}");
        
        JiapuMessageExample example = (JiapuMessageExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jiapumessage
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    public String updateByPrimaryKeySelective(JiapuMessage record) {
        BEGIN();
        UPDATE("jiapumessage");
        
        if (record.getCreatedate() != null) {
            SET("createDate = #{createdate,jdbcType=DATE}");
        }
        
        if (record.getMessage() != null) {
            SET("message = #{message,jdbcType=VARCHAR}");
        }
        
        if (record.getSenderid() != null) {
            SET("senderid = #{senderid,jdbcType=VARCHAR}");
        }
        
        if (record.getRecieverid() != null) {
            SET("recieverid = #{recieverid,jdbcType=VARCHAR}");
        }
        
        WHERE("messageid = #{messageid,jdbcType=INTEGER}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jiapumessage
     *
     * @mbggenerated Tue Apr 14 18:46:15 CST 2015
     */
    protected void applyWhere(JiapuMessageExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}