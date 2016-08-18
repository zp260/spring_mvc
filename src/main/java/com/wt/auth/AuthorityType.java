package com.wt.auth;

/**
 * Created by mrz on 16/8/15.
 */
public enum AuthorityType {
    /**
     * 查询员  12
     * 录入员  9,11,12,13
     * 审核员  10,12
     * 管理员  1,2,3,4,9,10,11,12,13,14
     * 总经理  1,2,3,4,8,9,10,11,12,13,14 (所有权限但不能修改会计)
     * 会计    5,6,7,8,12
     */

    USER_INSTERT("增加员工",0), //管理员
    USER_DELETE("删除员工",1),
    USER_EDIT("修改员工",2),//管理员
    USER_READ("查看员工",3),

    Finance_INSERT("增加资金相关",4),//会计(批次资金收付管理,合同资金到位管理)
    Finance_DELETE("删除资金相关",5),
    Finance_EDIT("修改资金相关",6),
    Finance_READ("查看资金相关",7),

    PortAndCurrency_MANAGE("货币和港口修改",8),//会计不能

    Contract_VERIFY("审核合同",9),//审核员=部门经理
    Contract_CREATE("创建合同", 10),//录入员
    Contract_FIND("查看合同", 11),//查询员，录入员，审核员
    Contract_MODIFY("修改合同", 12),//录入员
    Contract_DELETE("删除合同", 13),//总经理
    ;
    private String name;
    private int index;

    private AuthorityType(String name, int index) {
        this.name = name;
        this.index = index;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
