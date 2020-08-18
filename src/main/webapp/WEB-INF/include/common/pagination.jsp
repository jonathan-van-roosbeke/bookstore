<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<c:choose>
		<c:when test="${page.number ==0}">
		<li class="page-item">
		<a class="page-link" tabindex="-1" aria-disabled="true">Page précédente</a></li>
		</c:when>
		<c:when test="${page.number !=0}">
		<li class="page-item">
		<a class="page-link" href="?method=afficher&pageNo=${page.number +1 -1}" tabindex="-1">Page précédente</a></li>
		</c:when>
		</c:choose>
		
		<li class="page-item"><a class="page-link">${page.number +1 }</a></li>
		
		<c:choose>
		<c:when test="${page.number == page.totalPages-1}">
		<a class="page-link" tabindex="-1" aria-disabled="true">Page suivante</a></li>
		</c:when>
		<c:otherwise>
		<li class="page-item"><a class="page-link"
			href="?method=afficher&pageNo=${page.number +1 +1}">Page
				suivante</a></li>
		</c:otherwise>
		</c:choose>
		
	</ul>
	<ul class="pagination justify-content-center">
		<li class="page-item">Total ${page.totalElements } 
		<c:choose>
				<c:when test="${page.totalElements <=1}"> item</c:when>
				<c:when test="${page.totalElements >1}"> items</c:when>
			</c:choose> Total ${page.totalPages } 
			<c:choose>
				<c:when test="${page.totalPages <=1}"> page</c:when>
				<c:when test="${page.totalPages >1}"> pages</c:when>
			</c:choose>
		</li>
	</ul>
</nav>