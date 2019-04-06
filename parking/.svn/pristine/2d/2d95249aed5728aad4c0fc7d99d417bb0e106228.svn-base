function init() {
    $ .ajax({
                type : "POST",
                url : "showSellMonthProduct.action",
                dataType : "json",
                success : function (msg) {
                    var arr = $(".tr");
                    for (var i = arr.length - 1; i >= 0; i--) {
                        $(arr[i]).remove();
                    }
                    // 添加数据
                    var proList = msg.list;
                    if (proList.length > 0) {
                        for (var i = 0; i < proList.length; i++) {
                            var $tr = $("<tr class = 'tr' ></tr>");
                            var $td1 = $("<td></td>");
                            var $radio = $("<input type='radio' name='monthProduct'>");
                            $radio.val(proList[i].monthProductMoney);
                            $radio.attr("monthProductId", proList[i].monthProductId);
                            $radio.attr("monthProductName", proList[i].monthProductName);
                            $td1.append($radio);
                            var $td2 = $("<td></td>").html(proList[i].monthProductId);
                            var $td3 = $("<td></td>").html(proList[i].monthProductName);
                            var $td4 = $("<td></td>").html(proList[i].monthProductMoney);
                            $tr.append($td1);
                            $tr.append($td2);
                            $tr.append($td3);
                            $tr.append($td4);
                            $("#table").append($tr);
                        }
                    } else {
                        var $tr = $("<tr class = 'tr'><td colspan='4'>暂无产品</td></tr>");
                        $("#table").append($tr);
                    }
                    $(function () {
                        $('input:radio') .click(function () {
                               var domName = $(this).attr('name');
                               var $radio = $(this);
                               if ($radio.data('waschecked') == true) {
                            	   $radio.prop('checked', false);
                                   $("input:radio[name='"+ domName + "']").data('waschecked', false);
                               } else {
                                    $radio.prop('checked', true);
                                    $("input:radio[name='"+ domName+ "']").data('waschecked', false);
                                    $radio.data('waschecked', true);
                              }
                         });
                    });
                },
                error : function (msg) {
                    zuiAlert("请联系管理员。。。", 'danger');
                }

            });

}

init();

// 购买按钮的监听
$("#buyBtn").click(
                function () {
                    if ($("#carNum").val() == "") {
                        zuiAlert("请输入车牌号", 'danger');
                    } else {
                        if (isVehicleNumber($("#carNum").val())) {
                            if ($('input:radio[name="monthProduct"]:checked').attr('monthProductId') != null) {
                                $.ajax({
                                      type : "POST",
                                      url : "checkCarNum.action",
                                      data : {
                                          "carNum" : $("#carNum").val()
                                      },
                                      dataType : "json",
                                      success : function (msg) {
                                    	  console.log(msg);
                                    	  if (msg.type == 1) {
                                    		  $("#adddialog").css("display", "block");
                                    		  $("#money").val($('input:radio[name="monthProduct"]:checked').val());
                                      		} else {
                                      			zuiAlert(msg.message, 'danger');
                                      		}
                                      },
                                      error : function (msg) {
                                    	  zuiAlert("请联系管理员。。。", 'danger');
                                      }
                                });
                            } else {
                                zuiAlert("请选择产品", 'danger');
                            }
                        } else {
                            zuiAlert("请输入正确车牌号格式", 'danger');
                        }
                    }
                });

// 购买弹窗中的返回按钮监听
$("#addcancel").click(function () {
    $("#adddialog").css("display", "none");
});
// 购买弹窗中的支付按钮监听
$("#addcommit").click(
        function () {
            $.ajax({
                type : "POST",
                url : "addMonthProductService.action",
                data : {
                    "addId" : $('input:radio[name="monthProduct"]:checked').attr('monthProductId'),
                    "addName" : $('input:radio[name="monthProduct"]:checked').attr('monthProductName'),
                    "addMoney" : $('input:radio[name="monthProduct"]:checked').val()
                },
                dataType : "json",
                success : function (msg) {
                    if (msg.type == 1) {
                        zuiAlert(msg.message, 'success');
                        $("#adddialog").css("display", "none");
                        $("input[name=monthProduct]:checked").attr('checked',false);
                    } else {
                        zuiAlert(msg.message, 'danger');
                    }
                },
                error : function (msg) {
                    zuiAlert("请联系管理员。。。", 'danger');
                }
            });

        });

// 判断是否是车牌号的方法
function isVehicleNumber(vehicleNumber) {
    var result = false;
    if (vehicleNumber.length == 7) {
        var express = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$/;
        result = express.test(vehicleNumber);
    }
    return result;
}
