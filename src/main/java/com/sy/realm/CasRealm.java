package com.sy.realm;


import com.sy.mapper.FuncMapper;
import com.sy.mapper.UserMapper;
import com.sy.model.Func;
import com.sy.model.User;
import io.buji.pac4j.realm.Pac4jRealm;
import io.buji.pac4j.subject.Pac4jPrincipal;
import io.buji.pac4j.token.Pac4jToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.pac4j.core.profile.CommonProfile;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

public class CasRealm extends Pac4jRealm {
    @Autowired
    private FuncMapper funcRepository;

    @Autowired
    private UserMapper repository;

    @Autowired
    private DataSource dataSource;

    /**
     * 认证,使用CAS返回ticket认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        final Pac4jToken pac4jToken = (Pac4jToken) authenticationToken;
        final List<CommonProfile> commonProfileList = pac4jToken.getProfiles();
        final CommonProfile commonProfile = commonProfileList.get(0);
        System.out.println("单点登录返回的信息=====>" + commonProfile.toString());
        System.out.println("用户名为********" + commonProfile.getId());
        final Pac4jPrincipal principal = new Pac4jPrincipal(commonProfileList, getPrincipalNameAttribute());
        final PrincipalCollection principalCollection = new SimplePrincipalCollection(principal, getName());
        return new SimpleAuthenticationInfo(principalCollection, commonProfileList.hashCode());
    }

    /**
     * 授权,使用shiro的授权方式
     * 应该获取CAS返回用户信息,去数据库中查询相应权限信息,权限管理交由shiro
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)throws AuthenticationException {

        System.out.println("======>doGetAuthorizationInfo");
        SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
        Pac4jPrincipal principal = (Pac4jPrincipal) this.getAvailablePrincipal(principals);
        System.out.println("----------------------" + principal.getProfile().getId());
        User byUsername  = null;
        try {
            byUsername = repository.findByUsername(principal.getProfile().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //roleId
        Integer roleId = byUsername.getId();
        List<Func> byRoleId = null;
        try {
            byRoleId = funcRepository.selectByRoleId(roleId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //登录人的权限
        List<Func> funcs=null;
        try {
           funcs = funcRepository.selectByUsername(byUsername.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }


//        Iterator<Func> iterator = byRoleId.iterator();
//        while (iterator.hasNext()) {
//            authInfo.addStringPermission(iterator.next().getFuncUrl());
//        }

        Iterator<Func> iterator1 = funcs.iterator();

        while (iterator1.hasNext()) {
            authInfo.addStringPermission(iterator1.next().getFuncUrl());
        }

        System.out.println("authInfoauthInfoauthInfoauthInfoauthInfoauthInfo"+authInfo);
        return authInfo;

    }
}
