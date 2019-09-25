<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery-3.3.1.js"></script>
		<script type="text/javascript">
			function changeImage() {
				$("#imgVcode").prop("src","${pageContext.request.contextPath}/code/getCode?time"+new Date());
			}
			function isEmail(val){
	          	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,4}$/;
				if(!myreg.test(val))
				return '不是邮箱';
				return '是邮箱';
			};
            function checkEmail(){
                var email=$("#txtEmail").val();
                var result=isEmail(email);
                if(result=="是邮箱"){
                    $("#emailInfo").html("<img width='15px' src='${pageContext.request.contextPath}/front/images/label3.gif'/><font color=green>邮箱格式正确</font>");
                    return true;
                }
                if(result=="不是邮箱"){
                   $("#emailInfo").html("<img width='15px' src='${pageContext.request.contextPath}/front/images/wrong.gif'/><font color=red>邮箱格式不正确</font>");
                    return false; 
                }
            }
			function checkNickname(){
				var name=$("#txtNickName").val();
				var charCode=0;
				var length=0;
				for(var i=0;i<name.length;i++){
				   charCode=name.charCodeAt(i);
                   if(charCode>0&&charCode<127){
                       length+=1;
                   }else{
                       length+=2;
                   }
                }
				 if(length>=4&&length<=20){
                     $("#nameInfo").html("<img width='15px' src='${pageContext.request.contextPath}/front/images/label3.gif'/><font color=green>昵称格式正确</font>");
                     return true;
                }else{
                     $("#nameInfo").html("<img width='15px' src='${pageContext.request.contextPath}/front/images/wrong.gif'/><font color=red>昵称格式不正确</font>");
                    return false; 
                }			
			}
			function checkPassword(){
				var password=$("#txtPassword").val();
				var charCode=0;
				for(var i=0;i<password.length;i++){
				   charCode=name.charCodeAt(i);
                   if(charCode<0||charCode>127){
	                   $("#passwordInfo").html("<img width='15px' src='${pageContext.request.contextPath}/front/images/wrong.gif'/><font color=red>密码格式不正确</font>");
	                   return false; 
                   }
                }
                if(password.length>=6&&password.length<=20){
               		$("#passwordInfo").html("<img width='15px' src='${pageContext.request.contextPath}/front/images/label3.gif'/><font color=green>密码格式正确</font>");
               		 return true;
                }else{
                	$("#passwordInfo").html("<img width='15px' src='${pageContext.request.contextPath}/front/images/wrong.gif'/><font color=red>密码格式不正确</font>");
                    return false; 
                }
			}
			function checkSecond(){
				var password=$("#txtPassword").val();
				var second=$("#txtRepeatPass").val();
				if(password==second){
					$("#password1Info").html("<img width='15px' src='${pageContext.request.contextPath}/front/images/label3.gif'/>");
               		 return true;
				}else{
					$("#password1Info").html("<img width='15px' src='${pageContext.request.contextPath}/front/images/wrong.gif'/><font color=red>两次密码输入不一致</font>");
                    return false; 
				}
			}
			function checkCode(){
				var code=$("#txtVerifyCode").val();
				if(code==''){
					$("#codeInfo").html("<img width='15px' src='${pageContext.request.contextPath}/front/images/wrong.gif'/><font color=red>验证码不能为空</font>");
                    return false;
				}else{
					$("#codeInfo").html("<img width='15px' src='${pageContext.request.contextPath}/front/images/label3.gif'/>");
               		 return true;
				}
			}
			function changeStatus(){
				if(checkEmail()&&checkNickname()&&checkPassword()&&checkCode()&&checkSecond()){
					$("#btnClientRegister").prop("type","submit");
				}else{
					$("#btnClientRegister").prop("type","button");
				}
			}
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="${pageContext.request.contextPath}/user/register" id="f" >
				<h2>
					以下均为必填项&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					${message}
				</h2>
				<table class="tab_login" >
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
							<input name="user.email" onblur="checkEmail()" type="text" id="txtEmail" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
								<span id="emailInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="user.nickname" onblur="checkNickname()" type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nameInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="user.password" type="password" onblur="checkPassword()" id="txtPassword" class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="passwordInfo"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="password1" onblur="checkSecond()" type="password" id="txtRepeatPass" class="text_input"/>
							
							<div class="text_left" id="repeatPassValidMsg">
								<span id="password1Info"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="${pageContext.request.contextPath}/code/getCode" onClick="changeImage()"/>
							<input name="yzcode" onblur="checkCode()" type="text" id="txtVerifyCode" class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的四个字母。</span>
									<a href="javascript:changeImage()" id="change" >看不清楚？换个图片</a>
									<br/>
									<span id="codeInfo"></span>
								</p>
							</div>
						</td>
					</tr>
				</table>
				<div class="login_in">
					<input id="btnClientRegister" class="button_1" name="submit" onclick="changeStatus()" type="button" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

