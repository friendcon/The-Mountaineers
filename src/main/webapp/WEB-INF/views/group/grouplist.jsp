<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="groupone" items="${groups }" varStatus="status">
					<div class="group_container">
						<div class="group_img">
							<img class="group_profile_image" name="group_profile_image" src="/group/getImg/${groupone.group_no }" />
						</div>
						<div class="group_content_box">
							<h5><a href=""> ${groupone.group_name } </a></h5>
							<c:if test="${groupone.group_level eq 1}">
								<label class="level1">Level 1</label>
							</c:if>
							<c:if test="${groupone.group_level eq 2}">
								<label class="level2">Level 2</label>
							</c:if>
							<c:if test="${groupone.group_level eq 3}">
								<label class="level3">Level 3</label>
							</c:if>
							<p>${groupone.group_content }</p>
						</div>
					</div>
</c:forEach>