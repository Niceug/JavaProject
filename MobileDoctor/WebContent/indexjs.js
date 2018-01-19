var arr = new Array();
arr[0] = new Array("呼吸内科", "消化内科", "心血管内科", "神经内科", "肿瘤科", "内分泌科", "血液内科", "传染病科", "普外", "泌尿", "神经外（脑外）", "骨科", "口腔外科", "耳鼻喉", "整形", "烧伤", "胸外", "心脏外", "肝胆");
arr[1] = new Array("呼吸内科", "消化内科", "心血管内科", "神经内科", "肿瘤科", "内分泌科", "血液内科", "传染病科", "普外", "泌尿", "神经外（脑外）", "骨科", "口腔外科", "耳鼻喉", "整形", "烧伤", "胸外", "心脏外", "肝胆");
function SelectHospital(index) {
    var administrativeobj = document.getElementById("administrative");
    administrativeobj.innerHTML = "<option>选择科室</option>";
    var Keshi = arr[index];
    for(i = 0; i<arr[0].length;i++){
    	administrativeobj.innerHTML += ("<option>"+arr[index][i]+"</option>");
    	if(0 == index && 0 == i)
    		Doctor.innerHTML += ("<option>王医生</option>");
    	else if(0 == index && 1 == i)
    		Doctor.innerHTML += ("<option>张医生</option>");
    	else if(0 == index && 2 == i)
    		Doctor.innerHTML += ("<option>黄医生</option>");
    	else if(0 == index && 3 == i)
    		Doctor.innerHTML += ("<option>高医生</option>");
    	else if(0 == index && 4 == i)
    		Doctor.innerHTML += ("<option>常医生</option>");
    }
}
//登录窗口
$('#login').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // Button that triggered the modal
    var recipient = button.data('whatever') // Extract info from data-* attributes
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this)
    modal.find('.modal-title').text('New message to ' + recipient)
    modal.find('.modal-body input').val(recipient)
})

//注册
$('#register').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // Button that triggered the modal
    var recipient = button.data('whatever') // Extract info from data-* attributes
    // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
    // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
    var modal = $(this)
    modal.find('.modal-title').text('New message to ' + recipient)
    modal.find('.modal-body input').val(recipient)
})
var i = 1;
var img1 = "YLLBT1.png";
var img2 = "YLLBT2.png";
var img3 = "YLLBT3.png";
var obj;
function checkLogin()
{
    if($("#pUserName").val() == "")
    {
        alert("用户名不能为空");
    }
    if($("#pPassword").val() == "")
    {
        alert("密码不能为空");
    }
}

function checkRegister()
{
	if($("#registerpUserName").val() == "")
    {
        alert("用户名不能为空");
    }
    if($("#registerpPassword").val() == "")
    {
        alert("密码不能为空");
    }
    if($("#twiceregistepPassword").val() == "")
    {
        alert("请再次输入密码");
    }
    else
	{
		if(($("#registerpPassword").val()).equals($("#twiceregistepPassword").val()) != 0)
			{
				alert("两次输入的密码不一致");
			}
	}
    if(($("#SexMan").val() == "") && ($("#SexWoman").val() == ""))
    {
        alert("请选择性别");
    }
    
}


function init() {
	showvalf();
    $('.carousel').carousel({
        interval: 2000
    })
    obj = document.getElementById("lunbotu");
    setInterval(showAd, 2000);
}



function showAd() {
    i++;
    if(i == 1)
        obj.src = img1 ;
    if(i == 2)
        obj.src = img2;
    if(i == 3)
        obj.src = img3 ;
    if(i == 4)
        i =0;
}


$(function () {
    $("#1").click(function () {
        $("#keshiInfo").html("<div class = 'container-fluid' style = 'margin-top : 10px; margin-bottom: 20px; background-color: #fafafa'>" +
            "主要是牙齿上的疾病，如龋病（俗称蛀牙）、牙髓病、牙根尖周病。" +
            "其特点主要是牙痛，治疗手段在于消炎、止痛和修补牙洞，开展补牙、根管治疗、激光治疗过敏牙齿等项目。"+
            "</div>"
        );
    });
    $("#2").click(function () {
        $("#keshiInfo").html("<div class = 'container-fluid' style = 'margin-top : 10px; margin-bottom: 20px; background-color: #fafafa'>" +
            "专给14周岁以下的儿童少年诊治口腔疾病。包括各类儿童牙病、" +
            "开展窝沟封闭术等防治措施、宣传口腔预防保健知识、定期进行口腔保健普查等。" +
            "儿童少年正处在生长发育期，除了在生理、解剖、病理上有特点外，" +
            "儿童还有重要的心理特点，一般都有较重的惧怕心理。怎样取得儿童的合作是影响诊治工作质量的关键" +
            "，请家长按医生的要求，密切配合。" +
            "\n"+
            "</div>"
        );
    });
    $("#3").click(function () {
        $("#keshiInfo").html("<div class = 'container-fluid' style = 'margin-top : 10px; margin-bottom: 20px; background-color: #fafafa'>" +
            "是看牙列缺失、修复缺牙，包括全口假牙和部分假牙，在部分假牙中，又可分为活动假牙和固定假牙" +
            "，根据需要和可能来设计假牙的制作。开展活动、固定义齿修复、精密铸" +
            "造术、烤瓷冠、铸造桩核烤瓷联合冠、水晶牙饰等各种先进修复技术。\n"+
        "</div>"
    );
    });
    $("#4").click(function () {
        $("#keshiInfo").html("" +
            "<div class = 'container-fluid' style = 'margin-top : 10px; margin-bottom: 20px; background-color: #fafafa'>" +
            "口腔辅助科室\n" +
            "主要有口腔放射科（照各种X光片子），口腔检验科和口腔技工室等。病人一般都是在看完上述科室后，根据医生的建议，才去有关的口腔辅助科室。\n" +
            "放射科：拍摄牙片、咬翼片、咬牙合片、颌骨断层片、全景片、颅侧位定位片、颞颌关节开闭口片、个别牙定位片等。\n" +
            "检验科：化验凝血酶原时间；活化部分凝血酶原；纤维蛋白原时间；凝血酶时间；血细胞计数分析(RT三分类)；乙肝表面抗原(正LISA法)等。" +
            "</div>"
        );
    });

});



