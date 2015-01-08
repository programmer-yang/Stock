<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="modal-dialog modal-lg bg-color bg-img font-color">
	<div class="modal-content bg-color bg-img font-color">
		<div class="modal-header bg-color bg-img font-color">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h4 class="modal-title" id="myModalLabel">添加数据</h4>
		</div>
		<div class="modal-body bg-color bg-img font-color">

			<div class="span6">
				<!-- 标签   BEGIN -->
				<ul class="nav nav-tabs">
					<li class="active" id= "add_data_select_use" onclick="os.action('add_data_select_page', 'use')" >
						<a href="javascript:void(0)">日消耗</a>
					</li>
					<li id= "add_data_select_add" onclick="os.action('add_data_select_page', 'add')" >
						<a href="javascript:void(0)">进货</a>
					</li>
				</ul>
				<!-- 标签  END -->
				<hr class="featurette-divider">
				
				<!--日消耗内容区域  BEGIN -->
				<div class="row featurette" id= 'add_data_content_use'>
					<div class="col-md-8 ">
						<!-- 曲线图  BEGIN -->
						<div class="row placeholders hg3" id="add_line">
							<h2>abc</h2>
						</div>
						<!-- 曲线图  END -->
					</div>
					<form id="add_data_stock_use" action="data/add/save/stock/use" method="post">
						<div class="col-md-4">
							<div class="well text-center">
								<div class="form-group">
									<input type="text" class="form-control bg-color bg-img font-color" id="useStockName" name="stockId" data-provide="typeahead" data-items="4" autocomplete="off" placeholder="名称" />
								</div>
								<div class="form-group">
									<div class='input-group date' id='datetimepicker1'>
					                    <input type='text' name="time" class="form-control" autocomplete="off" placeholder="日期" />
					                    <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span>
					                    </span>
					                </div>
								</div>
								<div class="form-group">
									<input type="text" class="form-control bg-color bg-img font-color" id="stockNumber" name="number" data-provide="typeahead" data-items="4" autocomplete="off" placeholder="数量" />
								</div>
								<div class="form-group">
									<input type="text" class="form-control bg-color bg-img font-color" id="stockRemark" data-provide="typeahead" data-items="4" autocomplete="off" placeholder="备注" />
								</div>
								
								<div class="form-group ladda-mark">
									<button type="button" class="btn btn-info ladda-button btn-block"  data-style="zoom-out" onclick="os.action('save_stock_log_use',add_data_stock_use,this)">
										<span class="ladda-label">添加数据</span>
									</button>
									
									
									
								</div>
	
							</div>
						</div>
					</form>
				</div>
				<!-- 日消耗内容区域  END -->
				
				<!--进货内容区域  BEGIN -->
				<div class="row featurette hide" id= 'add_data_content_add' >
					<div class="col-md-8 ">
						<!-- 曲线图  BEGIN -->
						<div class="row placeholders hg3" id="add_data_line_add">
							<h2>def</h2>
						</div>
						<!-- 曲线图  END -->
					</div>
					<div class="col-md-4">
						<div class="well text-center">
							<div class="form-group">
								<input type="text" class="form-control bg-color bg-img font-color" id="useStockName" data-provide="typeahead" data-items="4" placeholder="名称" />
							</div>
							<div class="form-group">
								<div class='input-group date' id='datetimepicker1'>
				                    <input type='text' class="form-control" placeholder="日期" />
				                    <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span>
				                    </span>
				                </div>
							</div>
							<div class="form-group">
								<input type="text" class="form-control bg-color bg-img font-color" id="stockNumber" data-provide="typeahead" data-items="4" placeholder="数量" />
							</div>
							<div class="form-group">
								<input type="text" class="form-control bg-color bg-img font-color" id="stockRemark" data-provide="typeahead" data-items="4" placeholder="备注" onclick="os.mp.top.test();" />
							</div>
							
							<div class="form-group ladda-mark" >
							<!-- 
								<button type="button" class="btn btn-info ladda-button btn-block"  data-style="zoom-out" >
									<span class="ladda-label">添加数据</span>
								</button>
							 -->
							 <a href="#" id="form-submit" class="btn btn-primary btn-lg ladda-button" data-style="expand-right" data-size="l" onclick="os.mp.top.test(add_data_stock_use,this,event)">
							 	<span class="ladda-label">Submit form</span>
							 </a>
							 
							</div>

						</div>
					</div>
				</div>
				<!--进货内容区域  END -->
				
				
			</div>
		</div>
		<div class="col-xs-4 placeholder mp_pie_content "></div>
		<div class="modal-footer bg-color bg-img font-color">
			<button type="button" class="btn btn-default " data-dismiss="modal">Close</button>
		</div>
	</div>
</div>

