<jsp:include page="menu.jsp" />
        <div class="main-content" >
	<div class="title">Display Item</div>
	<div class="content">
        <div id ="table"></div>
        <script type="text/javascript">
            $(document).ready(function(){
                
                $.ajax({
                    url:"../GetAllItem",
                    type:"get",
                    data:null,
                    beforeSend:function(){},
                    success:function(data,status){
                            $("#table").html(data);
                        },
                    error:function(xhr,data,status){
                        
                    }
                });
            })
            </script>