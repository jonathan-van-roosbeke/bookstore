<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<li class="page-item"><a class="page-link"
			href="?method=afficher&pageNo=${page.number +1 -1}" tabindex="-1">Page
				précédente</a></li>
		<li class="page-item"><a class="page-link">${page.number +1 }</a>
		</li>
		<li class="page-item"><a class="page-link"
			href="?method=afficher&pageNo=${page.number +1 +1}">Page
				suivante</a></li>
	</ul>
	<ul class="pagination justify-content-center">
		<li class="page-item">Total ${page.totalElements } <c:choose>
				<c:when test="${page.totalElements <=1}"> item</c:when>
				<c:when test="${page.totalElements >1}"> items</c:when>
			</c:choose> Total ${page.totalPages } <c:choose>
				<c:when test="${page.totalPages <=1}"> page</c:when>
				<c:when test="${page.totalPages >1}"> pages</c:when>
			</c:choose>
		</li>
	</ul>
</nav>