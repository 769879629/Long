package com.sy.mapper;

import com.sy.model.Account;
import com.sy.model.Message;
import com.sy.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountMapper {

    @Select(value = "SELECT * FROM ACCOUNT_DETAIL  where moneyOut=0 and otherAccountId=(SELECT bankAccount FROM au_user where id = #{id})")
    List<Account> findBymoneyIn(Integer id) throws Exception;

    @Select(value = "SELECT * FROM ACCOUNT_DETAIL where moneyIn=0")
    List<Account> findBymoneyOut( ) throws Exception;

    @Insert(value = "insert into ACCOUNT_DETAIL(accountId,accountDate,moneyIn,moneyOut,type,otherAccountId) values (#{accountId},now(),#{moneyIn},0,0,#{otherAccountId})")
    Integer insertone(Account account)throws Exception;

    @Insert(value = "insert into ACCOUNT_DETAIL(accountId,accountDate,moneyIn,moneyOut,type,otherAccountId) values (#{accountId},now(),0,#{moneyOut},1,#{otherAccountId})")
    Integer insertdout(Account account)throws Exception;

    @Select(value = "select sum(moneyIn) as moneyIn , sum(moneyOut) as moneyOut from account_detail WHERE accountId=1")
    Account findbalance()throws Exception;

}
