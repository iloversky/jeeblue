package com.lovin.jeeblue;

import com.github.pagehelper.PageInfo;
import com.lovin.jeeblue.common.entity.SysUser;
import com.lovin.jeeblue.common.service.UserService;
import com.lovin.jeeblue.common.util.PropertyUtil;
import com.lovin.jeeblue.module.sys.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages="com.lovin.jeeblue")
public class JeeWebApplicationTests {

	@Autowired
    private UserService userService;

	@Autowired
	private SysUserService sysUserService;

	@Test
	public void testQuery() throws Exception {
		SysUser users = userService.findByUserName("admin");
        System.out.println(users.toString());
	}

	@Test
	public void testProperties() {
		System.out.println("value: " + PropertyUtil.getValue("server.port"));
	}

	@Test
	public void testFindUser() {
		PageInfo pageInfo = sysUserService.find(0, 10);
		System.out.println(pageInfo);
	}
}
