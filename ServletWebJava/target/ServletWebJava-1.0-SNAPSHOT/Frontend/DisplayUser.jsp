<jsp:include page="menu.jsp"/>

<script type="text/javascript">
     $(document).ready(function(){
        console.log("started");
        $.ajax({
            type: "get",
            url: "../DisplayUser",
            data: null,
            beforeSend: function(){},
            success: function(data,status){
                $("#table").html(data);
            },
            error:function(xhr,data,status){}
        });
});
</script>

<div class="main-content">
            <div class="title">User</div>
            <div class="content">
                <div id="table" class="display_table">
              
        
    </div>
        
            </div>
        </div>