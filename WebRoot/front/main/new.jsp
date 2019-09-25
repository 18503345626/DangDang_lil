<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">
	<c:forEach items="${newBook}" var="book2">
	<!--热销图书A开始-->
	<div class="second_d_wai">
		<div class="img">
			<a href="${pageContext.request.contextPath}/book/selectByBookId?bookId=${book2.book_id}" target='_blank'>
				<img src="${pageContext.request.contextPath}/back/img/${book2.cover}" class="a" border=0 /> 
			</a>
		</div>
		<div class="shuming">
			<a href="${pageContext.request.contextPath}/book/selectByBookId?bookId=${book2.book_id}" target="_blank">${book2.name}</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${book2.price}
		</div>
		<div class="price">
			当当价：￥${book2.dprice}
		</div>
		<div class="price">
			销量：<font color="red">${book2.sale}</font>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	<!--热销图书A结束-->
</c:forEach>
</div>
<div class="clear"></div>