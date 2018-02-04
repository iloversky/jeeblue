$(function() {
    loadUsers(1, 2);
});

function loadUsers(pageNum, pageSize) {
    $.get(ctxA + "/user/list?pageNum=" + pageNum + "&pageSize=" + pageSize, function(data){
        $("#userList").empty();
        $.each(data.list, function(i ,obj) {
            $("#userList").append("<tr><td>" + (i + 1) + "</td><td>" + obj.userId + "</td>"
                + "<td>" + obj.userName + "</td><td>" + obj.userEmail + "</td></tr>");
        });

        $('#pagination').bootstrapPaginator({
            bootstrapMajorVersion: 3,
            currentPage: data.pageNum,
            totalPages: data.pages,
            onPageClicked: function (event, originalEvent, type, page) {
                loadUsers(page, data.pageSize); // 页面跳转后调用ajax函数进行页面信息展示以及DOM操作
            }
        });
    });
}