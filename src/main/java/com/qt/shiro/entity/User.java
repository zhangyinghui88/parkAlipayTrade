package com.qt.shiro.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.qt.shiro.web.taglib.Functions;

/**
 * <p>User: Zhang yinghui
 * <p>Version: 1.0
 */
public class User implements Serializable {
    /**
     * 编号
     */
    private Long id; 
    
    /**
     * 所属公司
     */
    private Long organizationId; 
    
    /**
     * 所属公司名称
     */
    private String organizationName;
    /**
     * 用户名
     */
    private String username; 
    /**
     * 密码
     */
    private String password; 
    /**
     * 加密密码的盐
     */
    private String salt; 
    /**
     * 拥有的角色列表
     */
    private List<Long> roleIds;
    /**
     * 角色列表
     */
    private String roleNames;
    /**
     * 是否锁定
     */
    private Boolean locked;
    /**
     * 昵称
     */
    private String nickname;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCredentialsSalt() {
        return username + salt;
    }

    public List<Long> getRoleIds() {
        if(roleIds == null) {
            roleIds = new ArrayList<Long>();
        }
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }


    public String getRoleIdsStr() {
        if(CollectionUtils.isEmpty(roleIds)) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for(Long roleId : roleIds) {
            s.append(roleId);
            s.append(",");
        }
        return s.toString();
    }

    public void setRoleIdsStr(String roleIdsStr) {
        if(StringUtils.isEmpty(roleIdsStr)) {
            return;
        }
        String[] roleIdStrs = roleIdsStr.split(",");
        for(String roleIdStr : roleIdStrs) {
            if(StringUtils.isEmpty(roleIdStr)) {
                continue;
            }
            getRoleIds().add(Long.valueOf(roleIdStr));
        }
    }
    
    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", organizationId=" + organizationId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", roleIds=" + roleIds +
                ", locked=" + locked +
                '}';
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return organizationName .<br/>
     */
    public String getOrganizationName() {
        return Functions.organizationName(this.organizationId);
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月17日 下午2:58:17 <br/>
     * 参数: @param  organizationName 设置值.  <br/>
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    /**
     * 描述：获取属性值.<br/>
     * 创建人：yinghui zhang <br/>
     * 返回类型：@return roleNames .<br/>
     */
    public String getRoleNames() {
        return Functions.roleNames(roleIds);
    }

    /**
     * 创建人：yinghui zhang <br/>
     * 创建时间：2016年11月17日 下午2:58:17 <br/>
     * 参数: @param  roleNames 设置值.  <br/>
     */
    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    
}
