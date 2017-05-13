function delGround(gid) {

	if (confirm('确定删除该场地?')) {
		var url = "http://" + window.location.host
				+ "/GYM/admin/ground/index.html?action=delbyid&gid=" + gid;
		$.get(url, {}, function(data) {
		}, 'json');

		location.reload();
	}
}
