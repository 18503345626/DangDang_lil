<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->
		<c:forEach items="${listCategory}" var="category">
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='${pageContext.request.contextPath}/book/second?fid=${category.category_Id}&pageCode=${1}'>${category.name }</a>]
				</h3>
				<ul class="ul_left_list">
						<c:forEach items="${category.son}" var="c">
						<!--2级分类开始-->
						<li>
							<a href='${pageContext.request.contextPath}/book/second?fid=${category.category_Id}&sid=${c.category_Id}&pageCode=${1}'>${c.name}</a>
						</li>
						<!--2级分类结束-->
						</c:forEach>
				</ul>
				<div class="empty_left">
				</div>
			</div>

			<div class="more2">
			</div>
		</c:forEach>
		<!--1级分类结束-->
		


		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
