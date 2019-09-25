<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	<h2 class="t_xsrm">
		新书热卖榜
	</h2>
	<div id="NewProduct_1_o_t" onmouseover="">
	<ul>
		<li>&nbsp;&nbsp;&nbsp;
		<c:forEach items="${hotBoard}" var="book3">
			<a  target='_blank' href="${pageContext.request.contextPath}/book/selectByBookId?bookId=${book3.book_id}">
			 ${book3.name}
			</a></br>
			</c:forEach>
		</li>
	</ul>
	<h3 class="second">
		<span class="dot_r"></span><a href="#" target="_blank">更多&gt;&gt;</a>
	</h3>
</div>