<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>代码生成器</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#genCode").click(function () {
                var sql = $("#sql").val();
                var packageName = $("#packageName").val();
                $.ajax({
                    data: JSON.stringify({
                        packageName: packageName,
                        sql: sql
                    }),
                    contentType: "application/json;charset=UTF-8",
                    url: 'https://www.mlgb.cloud/gen/genCode',
                    dataType: 'json',//服务器返回json格式数据
                    type: 'post',//HTTP请求类型
                    timeout: 10000,//超时时间设置为10秒；
                    success: function (data) {
                        $('#downCode').attr('href', 'https://www.mlgb.cloud/gen/downCode/' + data.data);
                        $('#downCode').text('下载' + data.data);
                        $("#genCode").hide();
                        $("#downCode").show();
                    },
                    error: function (xhr, type, errorThrown) {

                    }
                });
            })
        });

        $(document).ready(function () {
            $('#down').click(function () {
                var entityName = $("#entityName").val();
                $('#down').attr('href', 'https://www.mlgb.cloud/gen/genService/' + entityName);
            });
            $('#downCode').click(function () {
                $("#genCode").show();
                $("#downCode").hide();
            });
        })
    </script>
</head>
<body style="background-color: whitesmoke">

<div class="container">
    <h3>代码生成器</h3>
    <div class="form-group">
        <p>SQL建表语句</p>
        <textarea id="sql" class="form-control" rows="7">CREATE TABLE `b_brand` (
  `id` int(15) unsigned NOT NULL AUTO_INCREMENT COMMENT '车辆品牌id',
  `name` varchar(100) NOT NULL COMMENT '品牌名称',
  `first_letter` varchar(2) NOT NULL COMMENT '品牌开头字母',
  `is_delete` tinyint(4) DEFAULT '0',
  `priority` varchar(4) DEFAULT '100' COMMENT '权重值',
  `created_at` datetime NOT NULL,
  `created_by` varchar(200) DEFAULT NULL COMMENT '用户id',
  `changed_at` datetime DEFAULT NULL,
  `changed_by` varchar(200) DEFAULT NULL,
  `brand_logo` varchar(255) DEFAULT NULL COMMENT '品牌图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=367 DEFAULT CHARSET=utf8 COMMENT='车库品牌表';</textarea><br>
        <p>包名</p>
        <input type="text" class="form-control" id="packageName" placeholder="" value="com.jy.gen"/><br>
        <button class="btn btn-success" id="genCode" type="button">生成</button>
        <a class="btn btn-success" style="display:none;" id="downCode" href="#">下载</a>
    </div>
    <br>
    <div class="form-group">
        <p><strong>鹿叭叭Service生成</strong></p>
        <p>输入表名,举例:</p>
        <pre>l_order_negotiate_price</pre>
        <input type="text" class="form-control" id="entityName" placeholder="表名">
    </div>
    <a class="btn btn-success" id="down" href="">生成</a>
    <nav class="navbar navbar-default navbar-fixed-bottom">
        <div class="container">
            <address>
                <span class="label label-info">Jy</span>
                <a href="mailto:#">ltmzy2@163.com</a><br><br>
                <span class="label label-success">code</span>
                <a href="https://gitlab.com/ltmzy2/grizzlybeerbuilder">https://gitlab.com/ltmzy2/grizzlybeerbuilder</a>
            </address>
        </div>
    </nav>
</div>
</body>
</html>