$(function() {
    openActiveMenu();
    createBreadcrumb();
});

/**
 * 很崩溃啊，thymeleaf使用不熟悉，导致每次点击菜单都重定向
 * 增加该方法根据请求 url设置被选中的菜单
 */
function openActiveMenu() {
    var ind = 0;
    var max = 5; // 防止死循环导致浏览器崩溃

    var url = window.location.pathname;
    var $activeMenu = $("#main-menu").find("a[href^='" + url + "']:first");
    $activeMenu.addClass("active-menu");
    var $pMenu = $activeMenu.closest("li");
    while(($pMenu.length == 1) && (ind++ < max)) {
        $pMenu.addClass("active");
        $pMenu = $pMenu.parent().closest("ul").addClass("in");
        $pMenu = $pMenu.parent().closest("li");
    }
}

/**
 * 创建面包屑导航
 */
function createBreadcrumb() {
    var breads = [];
    var ind = 0;
    var max = 5; // 防止死循环导致浏览器崩溃

    var $activeMenu = $("#main-menu").find(".active-menu");
    // 查找最近的匹配元素，优先匹配本身
    var $pMenu = $activeMenu.closest("li.active");
    while(($pMenu.length == 1) && (ind < max)) {
        breads[ind++] = {
            name: $pMenu.find("a:first").text().trim(),
            url: $pMenu.find("a:first").attr("href")
        }
        $pMenu = $pMenu.parent().closest("li.active");
    }
    breads = breads.reverse();
    for(var i in breads) {
        var bread = breads[i];
        var $li = $("<li></li>");
        /*if(i < (ind - 1)) {
            $li.append("<a href='" + bread.url + "'>" + bread.name + "</a>");
        } else {*/
            $li.append(bread.name).addClass("active");
        // }
        $("#breadcrumb").append($li);
    }
}