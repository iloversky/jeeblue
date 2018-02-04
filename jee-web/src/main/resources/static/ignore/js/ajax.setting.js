/**
 * ajax异常统一处理
 */
$(function() {
    $.ajaxSetup({
        beforeSend: function() {
        },
        error: function(xhr, textStatus, errorThrown) {
            alert(xhr.responseText);
        }
    });
});