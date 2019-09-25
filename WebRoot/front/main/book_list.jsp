<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/prototype-1.6.0.3.js"></script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="${pageContext.request.contextPath}/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath}/book/main'>当当图书</a> &gt;&gt;
			<font style='color: #cc3300'><strong>${cate.name}</strong> </font>
			<c:forEach items="${cate.son}" var="son">
				<c:if test="${sid==son.category_Id}">
				&gt;&gt;<font style='color: #cc3300'><strong>${son.name}</strong> </font>
				</c:if>
			</c:forEach>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
									<strong><font <c:if test="${sid==null||sid==''}"> style='color: #cc3300'</c:if>>
									&middot;${cate.name}&nbsp;</font></strong>

									</div>
								</div>
							</li>
							<div class="clear"></div>
							<c:forEach items="${cate.son}" var="son">
							<!--2级分类开始-->
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
									
										<a href="${pageContext.request.contextPath}/book/second?fid=${cate.category_Id}&sid=${son.category_Id}&pageCode=${1}"><font <c:if test="${sid==son.category_Id}"> style='color: #cc3300'</c:if>><strong>${son.name}&nbsp;</strong></font></a>
								
									</div>
									
								</div>
							</li>
						    <div class="clear"></div>
						    </c:forEach>
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							
							<div class='list_r_title_text3a'>
								<c:if test="${pageCode>1}">
								<a name=link_page_next href="${pageContext.request.contextPath}/book/second?fid=${fid}&sid=${sid}&pageCode=${pageCode-1}">
									<img src='${pageContext.request.contextPath}/front/images/page_up.gif' /> 
								</a>
								</c:if>
								<c:if test="${pageCode==1}">
									<img src='${pageContext.request.contextPath}/front/images/page_up.gif' /> 
								</c:if>
							</div>
	
							<div class='list_r_title_text3a'>
								<img src='${pageContext.request.contextPath}/front/images/page_up_gray.gif' />
							</div>
				
							<div class='list_r_title_text3b'>
								第${pageCode}页/共<c:if test="${count==0}">1</c:if><c:if test="${count!=0}">${count}</c:if>页
							</div>
							
							<div class='list_r_title_text3a'>
								<c:if test="${pageCode<count}">
								<a name=link_page_next href="${pageContext.request.contextPath}/book/second?fid=${fid}&sid=${sid}&pageCode=${pageCode+1}">
									<img src='${pageContext.request.contextPath}/front/images/page_down.gif' /> 
								</a>
								</c:if>
								<c:if test="${pageCode>=count}">
									<img src='${pageContext.request.contextPath}/front/images/page_down.gif' /> 
								</c:if>
							</div>
			
							<div class='list_r_title_text3a'>
								<img src='${pageContext.request.contextPath}/front/images/page_down_gray.gif' />
							</div>

							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						<c:forEach items="${list}" var="b">
						<div class="list_r_line"></div>
						<div class="clear"></div>
							<div class="list_r_list">
								<span class="list_r_list_book">
									<a name="link_prd_img" href='${pageContext.request.contextPath}/book/selectByBookId?bookId=${b.book_id}'>
										<img src="${pageContext.request.contextPath}/back/img/${b.cover}" /> 
									</a>
								</span>
								<h2>
									<a name="link_prd_name" href='${pageContext.request.contextPath}/book/selectByBookId?bookId=${b.book_id}'>${b.name }</a>
								</h2>
								<h3>
									顾客评分：100
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='#' name='作者'>${b.author}</a>
								</h4>
								<h4>
									出版社：
									<a href='#' name='出版社'>${b.press}</a>
								</h4>
								<h4>
									出版时间：<fmt:formatDate value="${b.press_date}" pattern="yyyy-MM-dd"/>
								</h4>
								<h5>
									${b.editor_recommend}
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">￥${b.price}</span>
									<span class="red">￥${b.dprice}</span>
									节省：￥${b.price-b.dprice}
								</h6>
								<span class="list_r_list_button"> 
								<a href="${pageContext.request.contextPath}/cart/addCart?bookId=${b.book_id}"> 
									<img src='${pageContext.request.contextPath}/front/images/buttom_goumai.gif' /> 
								</a>
								<span id="cartinfo"></span>
							</div>
						<div class="clear"></div>
						</c:forEach>
					
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
