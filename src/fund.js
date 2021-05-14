$(document).ready(function(){

    $("#alertSuccess").hide();
    $("#alertError").hide();

    getFunds();

    $("#newFundBtn").on("click", function(e){
        $("#newForm").toggle();
    });

    function getFunds(){
        $('#detailsBody').html('');
        $.ajax({
            url: 'http://localhost:',
            method: 'get',
            dataType: 'json',
            data: {
                test: 'test data'
            },
            success: function(data) {
                $(data).each(function(i, fund){
                    $('#detailsBody').append($("<tr>")
                        .append($("<td>").append(fund.fundNum))
                        .append($("<td>").append(fund.fundBodyName))
                        .append($("<td>").append(fund.email))
                        .append($("<td>").append(fund.innovatorName))
                        .append($("<td>").append(fund.projectName))
                        .append($("<td>").append(fund.fundAmount))
                        .append($("<td>").append(fund.fundPlan))
                        .append($("<td>").append(fund._id))
                        .append($("<td>").append(`
                                                <i class="far fa-edit editFun" data-fundid="`+fund._id+`"></i> 
                                                <i class="fas fa-trash deleteFun" data-fundid="`+fund._id+`"></i>
                                            `)));
                });
                loadButtons();
            }
        });
    }

    function getOneFund(id){
        $.ajax({
            url: 'http://localhost:' + id,
            method: 'get',
            dataType: 'json',
            success: function(data) {
                $($("#updateForm")[0].fundId).val(data._id);
                $($("#updateForm")[0].updateNum).val(data.fundNum);
                $($("#updateForm")[0].updateFBName).val(data.fundBodyName);
                $($("#updateForm")[0].updateEmail).val(data.email);
                $($("#updateForm")[0].updateIName).val(data.innovatorName);
                $($("#updateForm")[0].updateProName).val(data.projectName);
                $($("#updateForm")[0].updateFundAmount).val(data.fundAmount);
                $($("#updateForm")[0].updatePlan).val(data.fundPlan);
                $("#updateForm").show();
            }
        });
    }

    $("#submitDetails").on("click", function(e) {

        // Clear status
        $("#alertSuccess").text("");
        $("#alertSuccess").hide();
        $("#alertError").text("");
        $("#alertError").hide();

        // Form validation
        var status = validateFundForm();

        // If not valid
        if (status != true)
        {
            $("#alertError").text(status);
            $("#alertError").show();
            return;
        }

        let data = {
            fundNum: $($("#newForm")[0].fundNum).val(),
            fundBodyName: $($("#newForm")[0].fundBodyName).val(),
            email: $($("#newForm")[0].email).val(),
            innovatorName: $($("#newForm")[0].innovatorName).val(),
            projectName: $($("#newForm")[0].projectName).val(),
            fundAmount: $($("#newForm")[0].fundAmount).val(),
            fundPlan: $($("#newForm")[0].fundPlan).val()
        }

        postFund(data);
        $("#newForm").trigger("reset");
        $("#newForm").toggle();
        e.preventDefault();

    });
    function validateFundForm()
    {
       // fund number
        if ($("#fundNum").val().trim() == "")
        {
            return "Insert valid fund number.";
        }

        // funder name
        if ($("#fundBodyName").val().trim() == "")
        {
            return "Enter fund body name.";
        }

        // email
        if ($("#email").val().trim() == "")
        {
            return "Must fill valid email.";
        }

        // innovator name
        if ($("#innovatorName").val().trim() == "")
        {
            return "Enter innovator name.";
        }

        // project name
        if ($("#projectName").val().trim() == "")
        {
            return "Enter project name.";
        }

         // fund amount
        if ($("#fundAmount").val().trim() == "")
        {
            return "Enter amount.";
        }
        // fund plan
        if ($("#fundPlan").val().trim() == "")
        {
            return "Enter fund plan.";
        }

        return true;
    }


    function postFund(data) {
        $.ajax({
            url: 'http://localhost:',
            method: 'POST',
            dataType: 'json',
            data: data,
            success: function(data) {
                console.log(data);
                getFunds();
            }
        });
    }

    function loadButtons() {
        $(".editTut").click(function(e){
            getOneFund($($(this)[0]).data("fundid"));
            e.preventDefault();
        });

        $(".deleteTut").click(function(e){
            deleteFund($($(this)[0]).data("fundid"));
            e.preventDefault();
        })
    }

    function putFund(id, data){
        $.ajax({
            url: 'http://localhost:' + id,
            method: 'PUT',
            dataType: 'json',
            data: data,
            success: function(data) {
                console.log(data);
                getFunds();
            }
        });
    }

    $("#updateFundDetails").on("click", function(e) {
        let data = {
            fundNum: $($("#newForm")[0].fundNum).val(),
            fundBodyName: $($("#newForm")[0].fundBodyName).val(),
            email: $($("#newForm")[0].email).val(),
            innovatorName: $($("#newForm")[0].innovatorName).val(),
            projectName: $($("#newForm")[0].projectName).val(),
            fundAmount: $($("#newForm")[0].fundAmount).val(),
            fundPlan: $($("#newForm")[0].fundPlan).val()
        }

        putTutorial($($("#updateForm")[0].fundId).val(), data);
        $("#updateForm").trigger("reset");
        $("#updateForm").toggle();
        e.preventDefault();

    });



    function deleteFund(id){
        $.ajax({
            url: 'http://localhost:' + id,
            method: 'DELETE',
            dataType: 'json',
            success: function(data) {
                console.log(data);
                getFunds();
            }
        });
    }

});





