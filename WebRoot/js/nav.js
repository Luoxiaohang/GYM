function init() {

	// 初始主菜单
	if (def != 0) {
		var mdef = document.getElementById("m_" + def);
		mdef.className = "m_li_a";
	}

	// 初始子菜单
	if (def != 0) {
		var sdef = document.getElementById("s_" + def);
		sdef.className = "s_li_a";

	}
}

function mover(object) {
	// 主菜单
	if (document.getElementById("m_" + object).className != "m_li_a") {

		var mm = document.getElementById("m_" + object);
		mm.className = "m_li_a";
		// 初始主菜单先隐藏效果
		if (def != 0) {
			var mdef = document.getElementById("m_" + def);
			mdef.className = "m_li";
		}
		// 子菜单
		var ss = document.getElementById("s_" + object);
		ss.style.display = "block";
		// 初始子菜单先隐藏效果
		if (def != 0) {
			var sdef = document.getElementById("s_" + def);
			sdef.style.display = "none";
		}
	}
}

function mout(object) {
	// 主菜单
	var mm = document.getElementById("m_" + object);
	mm.className = "m_li";
	// 初始主菜单还原效果
	if (def != 0) {
		var mdef = document.getElementById("m_" + def);
		mdef.className = "m_li_a";
	}
	// 子菜单
	var ss = document.getElementById("s_" + object);
	ss.style.display = "none";
	// 初始子菜单还原效果
	if (def != 0) {
		var sdef = document.getElementById("s_" + def);
		sdef.style.display = "block";
	}
}