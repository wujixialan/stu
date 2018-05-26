/**
 * 判断显示在数据表格中的审核状态显示。
 */
function review(review) {
    if (review === 0) {
        return "待申核";
    }
    if (review === 1) {
        return "申核中";
    }
    if (review === 2) {
        return "申核完成无误";
    }
}

/**
 * 提示信息
 */
function msg($layer, content) {
    $layer.msg(content, {
        icon: 1,
    });
}

/**
 * 确认是否申核或申请。
 * @param url：请求地址
 * @param title：确认框标题
 * @param reviewInt：申核状态
 * @param value: 申核内容
 * @param obj
 */
function confirmSubmit(url, title, reviewInt, value, obj) {
    $.ajax({
        url: url,
        type: "post",
        data: {
            reviewId: reviewInt,
            reviewContent: value,
        },
        dataType: "json",
        success: function (res) {
            console.log(res);
            var reviewRes = review(res.reviewId);
            $(obj.tr[0]).find("td[data-field='reviewId']").children().text(reviewRes);
        },
        error: function (res) {
        }
    });
}
