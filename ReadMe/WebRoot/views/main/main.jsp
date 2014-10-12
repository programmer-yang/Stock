<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <title>Welcome ${currentUser.username}</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link href="<s:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<s:url value='/resources/css/dashboard.css'/>" rel="stylesheet">
    <link href="<s:url value='/resources/css/jquery.dataTables.css'/>" rel="stylesheet">
    <link href="<s:url value='/resources/css/main.css'/>" rel="stylesheet">
    
 
    <script type="text/javascript" src="<s:url value='/resources/js/jquery.min.js'/>"></script>
    <script type="text/javascript" src="<s:url value='/resources/js/highcharts.js'/>"></script>
    <script type="text/javascript" src="<s:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
	
	<script type="text/javascript" src="<s:url value='/resources/js/m/m.js'/>"></script>
	
	<script type="text/javascript" src="<s:url value='/resources/js/bootstrap.min.js'/>"></script>
	
	
	<script type="text/javascript">
		$(function(){
			os.mp.init();
		});
	</script>
  </head>
  <!-- data-target="#content_menu" -->
  <body>
    <!-- 顶部信息栏  BEGIN -->
    <!--  -->
    <nav class="navbar navbar-inverse navbar-fixed-top animated slideDown" role="navigation" id="navbar-example2">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Stock</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#main_page_box">admin</a></li>
            <li><a href="#stock_page_box">注销</a></li>
            <li><a onclick="os.mps.scroll.test();">帮助</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>
    <!-- 顶部信息栏  END -->
    
    <!-- 内容  BEGIN -->
    
    <div class="container-fluid" id="content_box">
      <div class="row" >
      	
	    <!-- 左侧菜单  BEGIN -->
	        <div class="col-sm-3 col-md-2 sidebar bs-docs-sidebar" id="content_menu">
	        	<!-- 菜单内容加载区域 -->
	        </div>
	        <!-- 左侧菜单  END -->
	        
	        <!-- 右侧内容  BEGIN -->
	       <div class="col-md-10">
		        <div class="col-sm-12 col-sm-offset-3 col-md-offset-2 main" id="main_page_box" >
		        	<!-- 首页图表加载容器 -->
					
		        </div>
				
				<div class="col-sm-12 col-sm-offset-3 col-md-offset-2 main" id="stock_page_box">
					<h1 class="page-header">库存</h1>
					
					<h2 class="sub-header">过去7天曲线图</h2>
					<div class="row placeholders " id="stock_line">
						
					</div>
					
					<h2 class="sub-header">店铺所有商品库存情况</h2>
					<div class=" dataTables_wrapper">
					<!-- 表格 BEGIN -->
						<table id="stock_table" class="display" cellspacing="0" width="100%">
						    <thead>
						        <tr>
						            <th>Name</th>
						            <th>Position</th>
						            <th>Office</th>
						            <th>Age</th>
						            <th>Start date</th>
						            <th>Salary</th>
						        </tr>
						    </thead>
						 
						    <tfoot>
						        <tr>
						            <th>Name</th>
						            <th>Position</th>
						            <th>Office</th>
						            <th>Age</th>
						            <th>Start date</th>
						            <th>Salary</th>
						        </tr>
						    </tfoot>
						 
						    <tbody>
						        <tr>
						            <td>Tiger Nixon</td>
						            <td>System Architect</td>
						            <td>Edinburgh</td>
						            <td>61</td>
						            <td>2011/04/25</td>
						            <td>$320,800</td>
						        </tr>
						        <tr>
						            <td>Garrett Winters</td>
						            <td>Accountant</td>
						            <td>Tokyo</td>
						            <td>63</td>
						            <td>2011/07/25</td>
						            <td>$170,750</td>
						        </tr>
						        <tr>
						            <td>Ashton Cox</td>
						            <td>Junior Technical Author</td>
						            <td>San Francisco</td>
						            <td>66</td>
						            <td>2009/01/12</td>
						            <td>$86,000</td>
						        </tr>
						        <tr>
						            <td>Cedric Kelly</td>
						            <td>Senior Javascript Developer</td>
						            <td>Edinburgh</td>
						            <td>22</td>
						            <td>2012/03/29</td>
						            <td>$433,060</td>
						        </tr>
						        <tr>
						            <td>Airi Satou</td>
						            <td>Accountant</td>
						            <td>Tokyo</td>
						            <td>33</td>
						            <td>2008/11/28</td>
						            <td>$162,700</td>
						        </tr>
						        <tr>
						            <td>Brielle Williamson</td>
						            <td>Integration Specialist</td>
						            <td>New York</td>
						            <td>61</td>
						            <td>2012/12/02</td>
						            <td>$372,000</td>
						        </tr>
						        <tr>
						            <td>Herrod Chandler</td>
						            <td>Sales Assistant</td>
						            <td>San Francisco</td>
						            <td>59</td>
						            <td>2012/08/06</td>
						            <td>$137,500</td>
						        </tr>
						        <tr>
						            <td>Rhona Davidson</td>
						            <td>Integration Specialist</td>
						            <td>Tokyo</td>
						            <td>55</td>
						            <td>2010/10/14</td>
						            <td>$327,900</td>
						        </tr>
						        <tr>
						            <td>Colleen Hurst</td>
						            <td>Javascript Developer</td>
						            <td>San Francisco</td>
						            <td>39</td>
						            <td>2009/09/15</td>
						            <td>$205,500</td>
						        </tr>
						        <tr>
						            <td>Sonya Frost</td>
						            <td>Software Engineer</td>
						            <td>Edinburgh</td>
						            <td>23</td>
						            <td>2008/12/13</td>
						            <td>$103,600</td>
						        </tr>
						        <tr>
						            <td>Jena Gaines</td>
						            <td>Office Manager</td>
						            <td>London</td>
						            <td>30</td>
						            <td>2008/12/19</td>
						            <td>$90,560</td>
						        </tr>
						        <tr>
						            <td>Quinn Flynn</td>
						            <td>Support Lead</td>
						            <td>Edinburgh</td>
						            <td>22</td>
						            <td>2013/03/03</td>
						            <td>$342,000</td>
						        </tr>
						        <tr>
						            <td>Charde Marshall</td>
						            <td>Regional Director</td>
						            <td>San Francisco</td>
						            <td>36</td>
						            <td>2008/10/16</td>
						            <td>$470,600</td>
						        </tr>
						        <tr>
						            <td>Haley Kennedy</td>
						            <td>Senior Marketing Designer</td>
						            <td>London</td>
						            <td>43</td>
						            <td>2012/12/18</td>
						            <td>$313,500</td>
						        </tr>
						        <tr>
						            <td>Tatyana Fitzpatrick</td>
						            <td>Regional Director</td>
						            <td>London</td>
						            <td>19</td>
						            <td>2010/03/17</td>
						            <td>$385,750</td>
						        </tr>
						        <tr>
						            <td>Michael Silva</td>
						            <td>Marketing Designer</td>
						            <td>London</td>
						            <td>66</td>
						            <td>2012/11/27</td>
						            <td>$198,500</td>
						        </tr>
						        <tr>
						            <td>Paul Byrd</td>
						            <td>Chief Financial Officer (CFO)</td>
						            <td>New York</td>
						            <td>64</td>
						            <td>2010/06/09</td>
						            <td>$725,000</td>
						        </tr>
						        <tr>
						            <td>Gloria Little</td>
						            <td>Systems Administrator</td>
						            <td>New York</td>
						            <td>59</td>
						            <td>2009/04/10</td>
						            <td>$237,500</td>
						        </tr>
						        <tr>
						            <td>Bradley Greer</td>
						            <td>Software Engineer</td>
						            <td>London</td>
						            <td>41</td>
						            <td>2012/10/13</td>
						            <td>$132,000</td>
						        </tr>
						        <tr>
						            <td>Dai Rios</td>
						            <td>Personnel Lead</td>
						            <td>Edinburgh</td>
						            <td>35</td>
						            <td>2012/09/26</td>
						            <td>$217,500</td>
						        </tr>
						        <tr>
						            <td>Jenette Caldwell</td>
						            <td>Development Lead</td>
						            <td>New York</td>
						            <td>30</td>
						            <td>2011/09/03</td>
						            <td>$345,000</td>
						        </tr>
						        <tr>
						            <td>Yuri Berry</td>
						            <td>Chief Marketing Officer (CMO)</td>
						            <td>New York</td>
						            <td>40</td>
						            <td>2009/06/25</td>
						            <td>$675,000</td>
						        </tr>
						        <tr>
						            <td>Caesar Vance</td>
						            <td>Pre-Sales Support</td>
						            <td>New York</td>
						            <td>21</td>
						            <td>2011/12/12</td>
						            <td>$106,450</td>
						        </tr>
						        <tr>
						            <td>Doris Wilder</td>
						            <td>Sales Assistant</td>
						            <td>Sidney</td>
						            <td>23</td>
						            <td>2010/09/20</td>
						            <td>$85,600</td>
						        </tr>
						        <tr>
						            <td>Angelica Ramos</td>
						            <td>Chief Executive Officer (CEO)</td>
						            <td>London</td>
						            <td>47</td>
						            <td>2009/10/09</td>
						            <td>$1,200,000</td>
						        </tr>
						        <tr>
						            <td>Gavin Joyce</td>
						            <td>Developer</td>
						            <td>Edinburgh</td>
						            <td>42</td>
						            <td>2010/12/22</td>
						            <td>$92,575</td>
						        </tr>
						        <tr>
						            <td>Jennifer Chang</td>
						            <td>Regional Director</td>
						            <td>Singapore</td>
						            <td>28</td>
						            <td>2010/11/14</td>
						            <td>$357,650</td>
						        </tr>
						        <tr>
						            <td>Brenden Wagner</td>
						            <td>Software Engineer</td>
						            <td>San Francisco</td>
						            <td>28</td>
						            <td>2011/06/07</td>
						            <td>$206,850</td>
						        </tr>
						        <tr>
						            <td>Fiona Green</td>
						            <td>Chief Operating Officer (COO)</td>
						            <td>San Francisco</td>
						            <td>48</td>
						            <td>2010/03/11</td>
						            <td>$850,000</td>
						        </tr>
						        <tr>
						            <td>Shou Itou</td>
						            <td>Regional Marketing</td>
						            <td>Tokyo</td>
						            <td>20</td>
						            <td>2011/08/14</td>
						            <td>$163,000</td>
						        </tr>
						        <tr>
						            <td>Michelle House</td>
						            <td>Integration Specialist</td>
						            <td>Sidney</td>
						            <td>37</td>
						            <td>2011/06/02</td>
						            <td>$95,400</td>
						        </tr>
						        <tr>
						            <td>Suki Burks</td>
						            <td>Developer</td>
						            <td>London</td>
						            <td>53</td>
						            <td>2009/10/22</td>
						            <td>$114,500</td>
						        </tr>
						        <tr>
						            <td>Prescott Bartlett</td>
						            <td>Technical Author</td>
						            <td>London</td>
						            <td>27</td>
						            <td>2011/05/07</td>
						            <td>$145,000</td>
						        </tr>
						        <tr>
						            <td>Gavin Cortez</td>
						            <td>Team Leader</td>
						            <td>San Francisco</td>
						            <td>22</td>
						            <td>2008/10/26</td>
						            <td>$235,500</td>
						        </tr>
						        <tr>
						            <td>Martena Mccray</td>
						            <td>Post-Sales support</td>
						            <td>Edinburgh</td>
						            <td>46</td>
						            <td>2011/03/09</td>
						            <td>$324,050</td>
						        </tr>
						        <tr>
						            <td>Unity Butler</td>
						            <td>Marketing Designer</td>
						            <td>San Francisco</td>
						            <td>47</td>
						            <td>2009/12/09</td>
						            <td>$85,675</td>
						        </tr>
						        <tr>
						            <td>Howard Hatfield</td>
						            <td>Office Manager</td>
						            <td>San Francisco</td>
						            <td>51</td>
						            <td>2008/12/16</td>
						            <td>$164,500</td>
						        </tr>
						        <tr>
						            <td>Hope Fuentes</td>
						            <td>Secretary</td>
						            <td>San Francisco</td>
						            <td>41</td>
						            <td>2010/02/12</td>
						            <td>$109,850</td>
						        </tr>
						        <tr>
						            <td>Vivian Harrell</td>
						            <td>Financial Controller</td>
						            <td>San Francisco</td>
						            <td>62</td>
						            <td>2009/02/14</td>
						            <td>$452,500</td>
						        </tr>
						        <tr>
						            <td>Timothy Mooney</td>
						            <td>Office Manager</td>
						            <td>London</td>
						            <td>37</td>
						            <td>2008/12/11</td>
						            <td>$136,200</td>
						        </tr>
						        <tr>
						            <td>Jackson Bradshaw</td>
						            <td>Director</td>
						            <td>New York</td>
						            <td>65</td>
						            <td>2008/09/26</td>
						            <td>$645,750</td>
						        </tr>
						        <tr>
						            <td>Olivia Liang</td>
						            <td>Support Engineer</td>
						            <td>Singapore</td>
						            <td>64</td>
						            <td>2011/02/03</td>
						            <td>$234,500</td>
						        </tr>
						        <tr>
						            <td>Bruno Nash</td>
						            <td>Software Engineer</td>
						            <td>London</td>
						            <td>38</td>
						            <td>2011/05/03</td>
						            <td>$163,500</td>
						        </tr>
						        <tr>
						            <td>Sakura Yamamoto</td>
						            <td>Support Engineer</td>
						            <td>Tokyo</td>
						            <td>37</td>
						            <td>2009/08/19</td>
						            <td>$139,575</td>
						        </tr>
						        <tr>
						            <td>Thor Walton</td>
						            <td>Developer</td>
						            <td>New York</td>
						            <td>61</td>
						            <td>2013/08/11</td>
						            <td>$98,540</td>
						        </tr>
						        <tr>
						            <td>Finn Camacho</td>
						            <td>Support Engineer</td>
						            <td>San Francisco</td>
						            <td>47</td>
						            <td>2009/07/07</td>
						            <td>$87,500</td>
						        </tr>
						        <tr>
						            <td>Serge Baldwin</td>
						            <td>Data Coordinator</td>
						            <td>Singapore</td>
						            <td>64</td>
						            <td>2012/04/09</td>
						            <td>$138,575</td>
						        </tr>
						        <tr>
						            <td>Zenaida Frank</td>
						            <td>Software Engineer</td>
						            <td>New York</td>
						            <td>63</td>
						            <td>2010/01/04</td>
						            <td>$125,250</td>
						        </tr>
						        <tr>
						            <td>Zorita Serrano</td>
						            <td>Software Engineer</td>
						            <td>San Francisco</td>
						            <td>56</td>
						            <td>2012/06/01</td>
						            <td>$115,000</td>
						        </tr>
						        <tr>
						            <td>Jennifer Acosta</td>
						            <td>Junior Javascript Developer</td>
						            <td>Edinburgh</td>
						            <td>43</td>
						            <td>2013/02/01</td>
						            <td>$75,650</td>
						        </tr>
						        <tr>
						            <td>Cara Stevens</td>
						            <td>Sales Assistant</td>
						            <td>New York</td>
						            <td>46</td>
						            <td>2011/12/06</td>
						            <td>$145,600</td>
						        </tr>
						        <tr>
						            <td>Hermione Butler</td>
						            <td>Regional Director</td>
						            <td>London</td>
						            <td>47</td>
						            <td>2011/03/21</td>
						            <td>$356,250</td>
						        </tr>
						        <tr>
						            <td>Lael Greer</td>
						            <td>Systems Administrator</td>
						            <td>London</td>
						            <td>21</td>
						            <td>2009/02/27</td>
						            <td>$103,500</td>
						        </tr>
						        <tr>
						            <td>Jonas Alexander</td>
						            <td>Developer</td>
						            <td>San Francisco</td>
						            <td>30</td>
						            <td>2010/07/14</td>
						            <td>$86,500</td>
						        </tr>
						        <tr>
						            <td>Shad Decker</td>
						            <td>Regional Director</td>
						            <td>Edinburgh</td>
						            <td>51</td>
						            <td>2008/11/13</td>
						            <td>$183,000</td>
						        </tr>
						        <tr>
						            <td>Michael Bruce</td>
						            <td>Javascript Developer</td>
						            <td>Singapore</td>
						            <td>29</td>
						            <td>2011/06/27</td>
						            <td>$183,000</td>
						        </tr>
						        <tr>
						            <td>Donna Snider</td>
						            <td>Customer Support</td>
						            <td>New York</td>
						            <td>27</td>
						            <td>2011/01/25</td>
						            <td>$112,000</td>
						        </tr>
						    </tbody>
						</table>
					<!-- 表格 END -->
					</div>
				</div>
		        <!-- 右侧内容  END -->
		        <div class="col-sm-12 col-sm-offset-3 col-md-offset-2 main" id="list_page_box">
					<h1 class="page-header">清单</h1>
		
					<h2 class="sub-header">今日进货清单</h2>
					<div class=" dataTables_wrapper">
				        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				        <h3>abc</h3>
					</div>
				</div>
		        <!-- 右侧内容  END -->
	        </div>
        
		</div>
	</div>
       
      <!-- 内容  END -->
      
    
    
  </body>
</html>
