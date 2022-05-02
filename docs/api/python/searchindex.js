Search.setIndex({docnames:["api/context/systemds_context","api/operator/algorithms","api/operator/node/frame","api/operator/node/list","api/operator/node/matrix","api/operator/node/scalar","api/operator/node/source","api/operator/operation_node","api/script_building/dag","api/script_building/script","api/utils/converters","api/utils/helpers","getting_started/install","getting_started/simple_examples","guide/algorithms_basics","guide/federated","guide/python_end_to_end_tut","index"],envversion:{"sphinx.domains.c":2,"sphinx.domains.changeset":1,"sphinx.domains.citation":1,"sphinx.domains.cpp":3,"sphinx.domains.index":1,"sphinx.domains.javascript":2,"sphinx.domains.math":2,"sphinx.domains.python":2,"sphinx.domains.rst":2,"sphinx.domains.std":1,"sphinx.ext.todo":2,sphinx:56},filenames:["api/context/systemds_context.rst","api/operator/algorithms.rst","api/operator/node/frame.rst","api/operator/node/list.rst","api/operator/node/matrix.rst","api/operator/node/scalar.rst","api/operator/node/source.rst","api/operator/operation_node.rst","api/script_building/dag.rst","api/script_building/script.rst","api/utils/converters.rst","api/utils/helpers.rst","getting_started/install.rst","getting_started/simple_examples.rst","guide/algorithms_basics.rst","guide/federated.rst","guide/python_end_to_end_tut.rst","index.rst"],objects:{"systemds.context":{SystemDSContext:[0,0,1,""]},"systemds.context.SystemDSContext":{__init__:[0,1,1,""],array:[0,1,1,""],close:[0,1,1,""],dict:[0,1,1,""],exception_and_close:[0,1,1,""],federated:[0,1,1,""],from_numpy:[0,1,1,""],from_pandas:[0,1,1,""],full:[0,1,1,""],get_stderr:[0,1,1,""],get_stdout:[0,1,1,""],list:[0,1,1,""],rand:[0,1,1,""],read:[0,1,1,""],scalar:[0,1,1,""],seq:[0,1,1,""],source:[0,1,1,""]},"systemds.operator":{Frame:[2,0,1,""],List:[3,0,1,""],Matrix:[4,0,1,""],OperationNode:[7,0,1,""],Scalar:[5,0,1,""],Source:[6,0,1,""],algorithm:[1,2,0,"-"]},"systemds.operator.Frame":{__init__:[2,1,1,""],cbind:[2,1,1,""],code_line:[2,1,1,""],compute:[2,1,1,""],pass_python_data_to_prepared_script:[2,1,1,""],rbind:[2,1,1,""],replace:[2,1,1,""]},"systemds.operator.List":{__init__:[3,1,1,""],code_line:[3,1,1,""],compute:[3,1,1,""],pass_python_data_to_prepared_script:[3,1,1,""]},"systemds.operator.Matrix":{"var":[4,1,1,""],__init__:[4,1,1,""],abs:[4,1,1,""],acos:[4,1,1,""],asin:[4,1,1,""],atan:[4,1,1,""],cbind:[4,1,1,""],cholesky:[4,1,1,""],code_line:[4,1,1,""],compute:[4,1,1,""],cos:[4,1,1,""],cosh:[4,1,1,""],max:[4,1,1,""],mean:[4,1,1,""],min:[4,1,1,""],order:[4,1,1,""],pass_python_data_to_prepared_script:[4,1,1,""],rbind:[4,1,1,""],replace:[4,1,1,""],rev:[4,1,1,""],round:[4,1,1,""],sin:[4,1,1,""],sinh:[4,1,1,""],sum:[4,1,1,""],t:[4,1,1,""],tan:[4,1,1,""],tanh:[4,1,1,""],to_one_hot:[4,1,1,""],to_string:[4,1,1,""]},"systemds.operator.OperationNode":{__init__:[7,1,1,""],code_line:[7,1,1,""],compute:[7,1,1,""],get_lineage_trace:[7,1,1,""],pass_python_data_to_prepared_script:[7,1,1,""],print:[7,1,1,""],write:[7,1,1,""]},"systemds.operator.Scalar":{__init__:[5,1,1,""],abs:[5,1,1,""],acos:[5,1,1,""],asin:[5,1,1,""],atan:[5,1,1,""],code_line:[5,1,1,""],compute:[5,1,1,""],cos:[5,1,1,""],cosh:[5,1,1,""],pass_python_data_to_prepared_script:[5,1,1,""],sin:[5,1,1,""],sinh:[5,1,1,""],tan:[5,1,1,""],tanh:[5,1,1,""],to_string:[5,1,1,""]},"systemds.operator.Source":{__init__:[6,1,1,""],code_line:[6,1,1,""],compute:[6,1,1,""]},"systemds.operator.algorithm":{abstain:[1,3,1,""],als:[1,3,1,""],alsCG:[1,3,1,""],alsDS:[1,3,1,""],alsTopkPredict:[1,3,1,""],arima:[1,3,1,""],bivar:[1,3,1,""],components:[1,3,1,""],confusionMatrix:[1,3,1,""],cox:[1,3,1,""],cspline:[1,3,1,""],csplineCG:[1,3,1,""],csplineDS:[1,3,1,""],cvlm:[1,3,1,""],dbscan:[1,3,1,""],dbscanApply:[1,3,1,""],decisionTree:[1,3,1,""],decisionTreePredict:[1,3,1,""],deepWalk:[1,3,1,""],discoverFD:[1,3,1,""],executePipeline:[1,3,1,""],ffTrain:[1,3,1,""],garch:[1,3,1,""],gaussianClassifier:[1,3,1,""],getAccuracy:[1,3,1,""],glm:[1,3,1,""],gmm:[1,3,1,""],gmmPredict:[1,3,1,""],gnmf:[1,3,1,""],hospitalResidencyMatch:[1,3,1,""],hyperband:[1,3,1,""],img_brightness:[1,3,1,""],img_crop:[1,3,1,""],img_cutout:[1,3,1,""],img_invert:[1,3,1,""],img_mirror:[1,3,1,""],img_posterize:[1,3,1,""],img_rotate:[1,3,1,""],img_sample_pairing:[1,3,1,""],img_shear:[1,3,1,""],img_transform:[1,3,1,""],img_translate:[1,3,1,""],imputeByFD:[1,3,1,""],imputeByFDApply:[1,3,1,""],km:[1,3,1,""],kmeans:[1,3,1,""],l2svm:[1,3,1,""],l2svmPredict:[1,3,1,""],lasso:[1,3,1,""],lenetTrain:[1,3,1,""],lm:[1,3,1,""],lmCG:[1,3,1,""],lmDS:[1,3,1,""],logSumExp:[1,3,1,""],matrixProfile:[1,3,1,""],miceApply:[1,3,1,""],msvm:[1,3,1,""],multiLogReg:[1,3,1,""],multiLogRegPredict:[1,3,1,""],na_locf:[1,3,1,""],naiveBayes:[1,3,1,""],outlier:[1,3,1,""],outlierByArima:[1,3,1,""],outlierByIQR:[1,3,1,""],outlierByIQRApply:[1,3,1,""],outlierBySd:[1,3,1,""],outlierBySdApply:[1,3,1,""],pca:[1,3,1,""],pnmf:[1,3,1,""],ppca:[1,3,1,""],randomForest:[1,3,1,""],scale:[1,3,1,""],shortestPath:[1,3,1,""],sigmoid:[1,3,1,""],slicefinder:[1,3,1,""],smote:[1,3,1,""],split:[1,3,1,""],splitBalanced:[1,3,1,""],stableMarriage:[1,3,1,""],statsNA:[1,3,1,""],steplm:[1,3,1,""],tSNE:[1,3,1,""],toOneHot:[1,3,1,""],underSampling:[1,3,1,""],univar:[1,3,1,""],winsorize:[1,3,1,""]},"systemds.script_building":{dag:[8,2,0,"-"],script:[9,2,0,"-"]},"systemds.script_building.dag":{DAGNode:[8,0,1,""],OutputType:[8,0,1,""]},"systemds.script_building.dag.DAGNode":{code_line:[8,1,1,""],compute:[8,1,1,""],get_lineage_trace:[8,1,1,""],pass_python_data_to_prepared_script:[8,1,1,""]},"systemds.script_building.script":{DMLScript:[9,0,1,""]},"systemds.script_building.script.DMLScript":{add_code:[9,1,1,""],add_input_from_python:[9,1,1,""],build_code:[9,1,1,""],execute:[9,1,1,""],execute_with_lineage:[9,1,1,""]},"systemds.utils":{converters:[10,2,0,"-"],helpers:[11,2,0,"-"]},"systemds.utils.converters":{matrix_block_to_numpy:[10,3,1,""],numpy_to_matrix_block:[10,3,1,""],pandas_to_frame_block:[10,3,1,""]},"systemds.utils.helpers":{create_params_string:[11,3,1,""],get_module_dir:[11,3,1,""]}},objnames:{"0":["py","class","Python class"],"1":["py","method","Python method"],"2":["py","module","Python module"],"3":["py","function","Python function"]},objtypes:{"0":"py:class","1":"py:method","2":"py:module","3":"py:function"},terms:{"0011352":13,"0014692":13,"00324092":13,"00616902":13,"0095087":13,"01039221":13,"01686351":13,"02033445":13,"02649209":13,"03839821":13,"04078623":1,"09961844":1,"0_242":12,"0_xxx":12,"100":[1,13,14],"1000":14,"10000":14,"11538199":1,"15000":16,"16281":16,"18954599":1,"198":15,"200":16,"20386541":1,"2205885":1,"242":12,"243":15,"255":1,"26812763":1,"288":15,"32561":16,"37957689":1,"39956035":1,"4327084":1,"43386048":1,"49858968":1,"5000":16,"50k":16,"54638565":1,"55358873":1,"57000751":1,"5x10":13,"60000":14,"60k":14,"8001":15,"8002":15,"8003":15,"abstract":17,"boolean":[0,1],"case":[1,12,14,16],"class":[0,1,2,3,4,5,6,7,8,9,16],"default":[0,1,2,3,4,5,6,7,16],"final":[14,16],"float":[0,1,2,3,4,5,7],"function":[0,1,2,3,4,5,6,7,11,13,14,16],"import":[0,1,6,12,13,14,15,16],"int":[0,1,2,3,4,5,7,16],"new":[0,1,13],"null":1,"return":[0,1,2,3,4,5,6,7,8,9,11,13,14,16],"short":14,"switch":1,"true":[0,1,4,16],"try":0,"var":4,"while":[0,1,7],And:14,But:14,FDs:1,For:[8,9,10,11,14,16],OPS:[8,9,10,11],One:[1,13,14],The:[0,1,2,3,4,5,6,7,10,12,13,14,15,16,17],Then:[12,16],There:[7,14,16],These:[16,17],Using:15,With:[14,16],__init__:[0,2,3,4,5,6,7],abil:0,abl:15,about:16,abov:[13,14,16],abs:[4,5],absolut:[0,4,5],abstain:1,acc:[14,16],accept:1,acceptor:1,access:[3,16],accord:1,account:16,accuraci:[1,14,16],achiev:[1,14,16],aco:[4,5],across:1,action:[2,3,4,5,6,7,8],activ:[1,2,3,4,5,6,7,8],actual:[1,2,3,4,5,6,7,8,13],acycl:8,add:[0,1,9,13,14,16],add_cod:9,add_input_from_python:9,added:[1,16],adding:[0,14,16],addit:[2,3,4,5,6,7,8,16],addition:[12,16],addr1:15,addr2:15,addr3:15,address:[0,15],adult:16,after:[1,12,15,16],afterward:16,again:[0,14,16],age:16,aggreg:4,algorithm:13,all:[0,1,2,3,4,5,6,7,8,11,12,13,15,16],allow:[0,6,16],alpha:1,alreadi:[9,16],als:1,alscg:1,alsd:1,also:[0,14,15,16],alstopkpredict:1,alter:16,although:[2,3,4,5,6],alwai:[0,1],amount:[1,14],analyz:16,ani:[0,1,3,8],anneal:1,annoi:0,anoth:[13,16],apach:[0,7,12,16,17],api:[6,12,16],append:[1,14,16],appli:[4,14],approxim:1,arbitrari:1,arcco:[4,5],arch:1,archiv:16,arcsin:[4,5],arctan:[4,5],arg:0,argument:[7,16],arima:1,arrai:[0,2,3,4,5,6,7,8,10,13,14,15,16,17],asarrai:15,asin:[4,5],assess:16,assign:5,assum:[1,4],atan:[4,5],attribut:[1,16],automat:[0,13],avail:[1,7,14,16],averag:[1,16],avg_sample_size_per_centroid:1,avoid:13,axi:4,b08:12,background:1,base:16,baselin:[1,14],basic:[11,14,16],batch:[1,16],batch_siz:[1,16],becaus:[0,12,14,16],becom:15,been:[14,16],befor:[2,3,4,5,6,7,8,16],begin:[0,1],behavior:9,belong:16,belonging:1,below:[1,2,3,4,5,6,16],bernoulli:1,best:1,beta:[1,16],betalist:1,betas_r:16,better:[1,16],between:[1,16],bia:[1,14],bias:16,bias_r:14,bin:[1,16],binari:[0,7],bind:[2,4,17],binomi:1,bit:[1,12],bivar:1,block:[0,10],bool:[0,1,2,3,4,5,6,7,8],both:[0,3,11,15,16],bottom:[14,15],box:1,bracket:[2,4,7],bright:1,build:[1,2,3,4,5,6,7,8,9,12],build_cod:9,built:[0,7,13,16],builtin:[1,2,3,4,5,6,7,8,14],calcul:[0,1,4,5,13,14,16],call:[0,1,2,3,4,5,6,7,8,11,13,14,15,16],can:[0,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16],candid:1,canon:1,capabl:16,capac:1,capit:16,categor:[1,16],categori:[1,16],cbind:[2,4],cell:[0,13],censu:16,center:1,centroid:1,certain:16,chang:[1,14],channel:1,channel_max:1,check:[1,4,12,15],choleski:4,choos:[1,16],chosen:1,circumst:16,classifi:[14,16],clean:[12,17],cleanup:0,clone:12,close:[0,13],cluster:1,clustermodel:1,code:[1,2,3,4,5,6,7,8,9,12,13,14,16],code_lin:[2,3,4,5,6,7,8],coeffici:1,col:[0,1,15,16],colmean:1,color:1,colsd:1,column:[0,1,2,4,14,16],columnid:1,com:12,combin:[14,16],come:14,command:[0,12,15,16],comment:1,common:16,commonli:14,compat:[12,13],compil:17,complet:[0,13,16],compon:1,comput:[0,1,2,3,4,5,6,7,8,13,14,15,16],concaten:[2,4],conf_typ:1,confid:1,confusion_matrix_ab:16,confusionmatrix:[1,16],conj:1,conjug:1,conjunct:1,connect:[0,1],consecut:[1,16],consid:1,consist:16,constant:1,constraint:1,construct:[0,1,2,3,4,5,6,7],constructor:3,cont:1,contain:[0,1,2,3,4,5,7,12,14,16],content:16,context:[0,1,2,3,4,5,6,7,9,10,13,14,15,16],continu:[1,16],continuo:1,contiuou:1,contrast:17,control:1,conveni:16,converg:1,convert:[1,4,5,11],coordin:[0,1,15],core:[0,1,2,10],corner:1,correct:1,correctli:[0,14,15,16],correspond:[1,14],cos:[4,5],cosh:[4,5],could:14,count:1,countri:16,covari:1,cox:1,cpu:17,creat:[0,2,3,4,5,6,7,8,9,11,13,15,16],create_params_str:11,create_python_dist:12,criterion:1,crop:1,cross:16,cspline:1,csplinecg:1,csv:[0,1,15,16],current:[0,10,15,16],custom:16,cvlm:1,dag:[2,3,4,5,6,7,9],dag_root:9,dagnod:[0,1,2,3,4,5,7,8,9],data:[0,1,2,3,4,5,6,7,8,9,13,14,15,17],data_typ:16,datafram:[0,2,10],datamanag:[14,16],dataset:[1,13,16,17],dataset_jspec:16,dataset_path_test:16,dataset_path_train:16,datasetmanag:16,datatensor:17,datatyp:16,dbscan:1,dbscanappli:1,deactiv:1,deal:16,debug:1,decai:1,decisiontre:1,decisiontreepredict:1,declar:[1,6,16],decomposit:4,decreas:[1,4],deepwalk:1,defin:[0,1,2,3,4,5,6,8],definit:4,degre:1,delet:[1,16],delimit:15,delta:1,depend:[1,12],depict:1,deploy:17,depth:1,deriv:[2,3,4,5],descent:1,describ:[9,16],destin:7,detail:[0,1,16],develop:13,devianc:1,dfam:1,dict:[0,1,2,3,4,5,6,7,8,11],dictionari:[0,3,11],differ:[0,1,14,15,16,17],differenc:1,difficulti:16,dim:15,dimens:[1,14,15,17],dimension:[1,17],dimr:16,direct:[1,8],directli:[0,13,16],directori:16,discern:1,discoverfd:1,discret:16,disk:[0,2,3,7],disp:1,dispers:1,distanc:1,distinct:[14,16],distribut:[0,1,12,14,17],dml:[0,2,3,4,5,6,7,8,9,11,16],dmlcode:9,dmlscript:9,doc:16,doe:[13,14,15],doesn:8,doing:1,don:1,done:[0,14,15],doubl:[0,1,2,3,4,5,6,7,13,15,16],download:[14,16],drawback:1,dtype:13,dummycod:16,duplic:1,dure:[1,16],each:[0,1,14,15,16],earli:1,easi:16,easili:[7,13],edu:16,educ:16,effici:17,eigen:1,either:[1,2,3,4,5,17],element:13,embed:1,empti:1,enabl:15,encod:[1,4,16],end:[0,1,17],end_steps:1,end_vicin:1,engin:17,ensur:[0,4,16],entail:16,entir:17,entri:16,entropi:1,enumer:8,environ:12,epoch:[1,16],eps:1,epsilon:1,equal:[1,2,3,4,5,6,7,8],equi:16,equiheight:1,equival:7,err_typ:1,error:[0,1,7],estim:1,etc:[0,2,3,4,5,6,7],eval:1,evalu:[1,2,3,4,5,6,7,8,16],everi:[1,2,3,4,5,6,7,16],everyth:14,exampl:[1,13,14,16],exce:16,except:[0,16],exception_and_clos:0,exchang:13,exclud:1,exectut:0,execut:[0,1,2,3,4,5,6,7,8,9,12,13,15,16,17],execute_with_lineag:9,executepipelin:1,exhaust:14,exist:17,expect:[2,3,4,5,6,7,14],expens:0,expertis:17,explan:[14,16],explor:14,extra:7,extract:[14,16],facilit:17,factor:1,failur:1,fall:1,fals:[0,1,2,3,4,5,6,7,8,15],famili:1,featur:[1,13,14,16,17],feature_subset:1,fed:15,fed_a:15,feder:0,feed:16,few:12,ffn_packag:16,fftrain:1,file:[0,1,6,7,13,15,16],filepath:16,fill:[0,1,13],fill_valu:1,find:1,finish:0,first:[1,2,4,12,13,14,15,16,17],fisher:1,fit:[1,14,16],fix:1,flag:[1,4,16],flagscount:1,flexibl:0,flip:1,fnlwgt:16,fnn:16,follow:[0,1,12,15,16],forest:1,form:0,format:[1,7,11,15,16],forward:[1,16],found:16,fraction:[0,1,16],frame:[0,1,3,4,10,16],framework:16,from:[0,1,2,3,4,5,6,7,8,9,12,13,14,15,16,17],from_numpi:[0,1,13,14,15,16],from_panda:0,full:[0,1,13],func:3,func_01:0,fundament:4,further:[14,16],gain:16,gamma:1,garch:1,gaussian:1,gaussianclassifi:1,gemm:1,gener:[0,1,2,3,4,5,6,7,8,13,16],get:[0,1,2,3,4,5,6,7,8,9,13,16],get_i:16,get_lineage_trac:[7,8],get_module_dir:11,get_preprocessed_dataset:16,get_stderr:0,get_stdout:0,get_test_data:14,get_test_label:14,get_train_data:14,get_train_label:14,get_x:16,getaccuraci:1,getter:0,gini:1,git:12,github:[0,7,12,16],give:[0,11,14],given:[0,1,7,10],glm:1,global:16,global_mean:16,global_mod:16,gmm:1,gmmpredict:1,gnmf:1,goal:16,goe:[13,14],good:[14,16],gpu:17,gradient:1,graduent:1,graph:[1,8],greater:1,greenwood:1,group:[1,16],guid:15,had:16,hand:[2,4],handl:[0,3],happen:14,has:[0,1,9,14,16],have:[0,1,12,13,14,15,16,17],hdf:7,header:[15,16],heavi:16,height:1,held:0,help:17,here:[14,15,16],heterogen:17,hidden:16,high:[13,17],higher:1,highest:14,highli:13,hin:1,histori:1,hold:16,homogen:17,horizont:1,horizontal_axi:1,hospit:1,hospitalresidencymatch:1,hot:[1,16],hour:16,how:[14,16],html:16,http:[0,7,12,16],hybrid:17,hyper:1,hyperband:1,hyperparamet:16,icpt:1,ics:16,ident:16,identifi:[2,3,4,5,6,7],ignor:1,imag:[1,14],img_bright:1,img_crop:1,img_cutout:1,img_in1:1,img_in2:1,img_in:1,img_invert:1,img_mirror:1,img_poster:1,img_rot:1,img_sample_pair:1,img_shear:1,img_transform:1,img_transl:1,immedi:7,implement:[0,14],improv:[7,14],impur:1,imput:[1,16],imputebyfd:1,imputebyfdappli:1,includ:[0,1,16],include_mean:1,incom:16,inconsist:16,increas:[4,14,16],increment:0,index:[0,1,4],index_return:4,indic:[1,14,15],individu:16,infin:1,inform:[1,2,3,4,5,6,7,8,16],init_param:1,initi:[1,16],inner:1,inp_x:1,input:[1,2,3,4,5,6,7,9,14],input_var:9,insert:0,insid:[1,13,16],instal:[14,16],instanc:[0,1,2,10,13,14],instead:[12,13],instruct:[0,15],integ:[0,1,14],integr:[1,16,17],intend:[2,3,4,5,6,7,8,9],intercept:1,interest:16,interfac:17,intern:[0,1,8,9,10,11,13],interpol:16,interpret:0,interv:[1,16],introduc:16,involv:12,iqr:1,is_python_local_data:[2,3,4,5,6,7],is_verbos:1,isdir:15,isit:1,isweight:1,item:1,iter:[0,1,2,3,4,5,7,11,14],iterait:1,its:[1,15],itself:3,jacobi:1,jar:12,java:[0,2,3,4,5,7,8,12],java_gatewai:[2,3,4,5,7,8,9,10],javaobject:[2,3,4,5,7,8,9,10],json:16,jspec:16,just:[1,12],jvm:[0,2,3,4,5,7,8,10],jvmview:[7,8,10],keep:[1,14],keyword:16,kmax:1,kmean:1,know:14,known:14,kth:1,kwarg:[0,1,4,5,7],l2svm:[1,13],l2svmpredict:1,label:[1,13,14,16],lamb:0,lambda:[0,1],languag:[0,7,16,17],laplac:1,largest:1,lasso:1,last:[1,15,16],later:[14,16],layer:16,lazi:[2,3,4,5,6,7,8,15,16],lazili:7,leaf:1,learn:[1,14,16],learning_r:[1,16],least:0,leav:0,left:[0,1,15],lenettrain:1,length:1,less:1,let:13,level:[1,3,13,17],leverag:15,librari:12,lifecycl:17,lift:16,like:[1,3,13,14,15,16],likelihood:1,limit:16,line:[0,1,2,3,4,5,6,7,8,9,12,16],lineag:[2,3,4,5,6,7,8,9],linear:1,link:1,list:[0,1,14,15,16],lmcg:1,lmd:1,load:14,loader:14,loc:15,local:[2,3,4,5,6,7,9,15,17],local_data:[2,4],localhost:15,locat:[1,7,15],locf:1,log:1,logist:[14,16],logsumexp:1,look:[1,7,12,13,15,16],loop:1,loss:[1,16],loss_fcn:1,lower:1,lpow:1,m_re:13,m_res_np:13,machin:[1,2,3,4,5,7,8],made:[14,16],mai:17,main:12,make:[12,13,14,15,16],manag:0,mani:16,map:16,margin:1,marit:16,market:0,mask:1,mat:0,match:1,matric:[2,4,15],matrix:[0,1,2,3,5,6,7,10,14,15],matrix_block_to_numpi:10,matrixblock:10,matrixprofil:1,maven:12,max:[0,1,4],max_it:1,max_iter:1,max_valu:1,maxi:[1,14],maxii:1,maximum:[0,1],maxiter:1,maxl:1,mean:[1,2,3,4,5,6,7,14,16],measur:1,median:1,memori:[1,17],mention:16,messag:1,meta:1,metadata:15,method:[0,1,2,3,4,5,6,7,8,16],miceappli:1,might:[0,12],mii:1,min:[0,1,4],minim:1,minimum:1,minpt:1,minsup:1,misclassifi:1,miss:[1,16],mix:12,mixtur:1,mkdir:15,mnist:14,mode:[1,12,16],model:[1,13,14,17],modif:16,modifi:[1,13,16],modul:11,moi:1,momentum:1,monoton:1,more:[0,1,14,16],most:[1,4,7,16],move:1,msvm:1,mtd:[15,16],much:14,multi:[2,3,4,5,6,7,17],multilogreg:[1,14,16],multilogregpredict:[1,14,16],multinomi:16,multipl:[1,2,3,4,5,6,7,13,14],multipli:[13,14,15],must:[0,1,4],mvn:12,n_compon:1,na_locf:1,naivebay:1,name:[0,1,2,3,4,5,6,7,8,9,11,16],named_input_nod:[2,3,4,5,6,7],named_input_var:[2,3,4,5,6,7,8],named_paramet:11,nan:1,nastr:16,nativ:16,natur:4,ncol:[1,16],nearest:[1,4],necessari:[0,12,13,16],need:[0,1,12,15,16],neg:1,neighborhood:1,neighbour:1,nest:17,neural_net_sourc:16,neural_net_src_path:16,neuron:16,newer:12,newlin:16,newton:1,next:15,nical:1,node:[0,1,2,3,4,5,6,8],noisi:1,nomin:1,non:[0,1,12],none:[0,1,2,3,4,5,6,7,8,9],nonzero:1,norm:1,normal:0,note:[0,12,13,14,15,16],noteworthi:[14,16],noth:[7,13,14,16],now:[14,16],np_arr:10,nrow:1,num:[1,16],num_class:[1,4],num_leaf:1,num_sampl:1,num_tre:1,number:[0,1,4,12,13,14,16],number_of_output:[2,3,4,5,6,7],numbin:16,numclass:1,numer:1,numpi:[0,1,2,3,4,5,6,7,8,10,12,13,14,15,16],numpy_to_matrix_block:10,obj:1,object:[0,1,2,3,4,5,6,7,8,9,10,16],observ:1,occup:16,occurr:16,offer:16,offset_i:1,offset_x:1,ohe:1,older:12,onc:[0,1,12,15,16],one:[0,1,3,4,6,13,14,15,16],onehot:4,onehotencod:4,ones:[13,15],onli:[0,1,2,3,4,5,6,7,8,9,13,14,16],open:[0,12,15],openjdk:12,oper:[0,1,2,3,4,5,6,8,9,14,17],operation_nod:[0,4,7],operationnod:[0,1,2,3,4,5,6,7],opposit:1,optim:1,option:[1,16],order:[1,4,15,16,17],ordin:1,other:[1,2,3,4,5,6,7,12,14,15],otherwis:1,ouptut:1,our:[9,11,13,14,15,16],out:[0,1],out_activ:1,out_h:1,out_w:1,outer:1,outlier:1,outlierbyarima:1,outlierbyiqr:1,outlierbyiqrappli:1,outlierbysd:1,outlierbysdappli:1,output:[0,1,2,3,4,5,6,7,8,9,12,13,14],output_typ:[2,3,4,5,6,7],outputtyp:[5,7,8],over:[1,17],overal:[14,16],overflow:1,overload:7,oversampl:1,overview:16,own:1,packag:[12,13,17],page:14,pair:[0,2,3,4,5,6,7,8],panda:[0,2,7,10],pandas_to_frame_block:10,parallel:1,param:[0,1,2,4],paramet:[0,1,2,3,4,5,6,7,8,9,10,11,14,16],paramrang:1,pars:[0,16],part:[12,16],partial:1,particular:16,pass:[0,2,3,4,5,7,8,9,16],pass_python_data_to_prepared_script:[2,3,4,5,7,8],path:[0,1,6,7,11,15,16],path_to_fil:0,pathlik:[0,11],patter:3,pattern:[2,4,16],pca:1,pd_df:10,pdf:0,per:[1,14,16],percentag:1,perfectli:14,perform:[1,2,3,4,5,6,7,13,14,16],period:1,perplex:1,person:16,peto:1,pick:16,pictur:14,pip3:12,pixel:[1,14],plain:1,plan:17,pleas:[12,16],pnmf:1,point:[0,1,12],pointer:10,poison:0,poisson:1,port:[0,15],posit:[1,2,3,4,5,6,7],possibl:[1,2,3,4,5,6],potenti:14,power:1,ppca:1,precis:16,precisions_choleski:1,predic:1,predict:[1,14,16],prefer:1,prepar:[2,3,4,5,7,8,9],prepared_script:[2,3,4,5,7,8],preparedscript:9,preprocess:14,preprocess_packag:16,preprocess_src_path:16,prerequisit:[14,16],presenc:1,preserv:1,previou:14,previous:16,primit:3,print:[0,1,2,3,4,5,6,7,8,13,14,15,16],print_imported_method:[0,6,16],probabl:[0,1,14,16],procedur:[0,1],process:[0,1,13,16],program:[0,16],project:12,properti:16,proport:1,propos:1,protocol:0,provid:[1,3,11,13,14,16,17],ptt:1,py4j:[2,3,4,5,7,8,9,10,12,13],python:[0,2,3,4,5,6,7,8,9,12,13,15,17],python_ffn:16,quadrat:1,quartil:1,queue:0,quick:13,quit:12,race:16,radian:1,rand:[0,1,13],randint:13,random:[0,1,13],randomforest:1,rang:[0,1,13,14],rank:1,rate:[1,16],ratio:1,rbind:[2,4,16],reach:1,reachabl:1,read:[0,1,2,3,7,13],readi:[12,14],readwrit:[0,7],realist:14,reandomli:1,recod:[1,16],recogn:7,recommend:[2,3,4,5,6,13],reconstruct:1,record:1,rectangl:1,reduc:[1,14,16],reduced_dim:1,reduct:1,refer:[0,1,7,15,16],reg:1,reg_covar:1,regard:16,region:1,regress:[1,14,16],regular:1,rel:[0,1],relat:16,relationship:16,rememb:[2,3,4,5,6,7,13],remov:[1,16],repair:1,repairmethod:1,replac:[1,2,4,14,16],replace_valu:16,repositori:[12,15],repres:[0,1,2,3,4,5,6,7,8,11],represent:[4,5,10],request:[1,12],requir:[1,14,15,16],res:0,rescal:1,resembl:14,resid:1,residu:1,resourc:16,respect:[1,2,3,4,5,6,7,16],respons:[1,14],restart:1,result:[1,2,3,4,5,6,7,8,9,13,14,15,16],resultvari:9,ret:15,returnv:16,rev:4,reveal:1,revers:4,right:[2,4],rnk:1,robust:1,root:[1,12],rotat:1,round:4,row:[0,1,2,4,14,15,16],rule:1,run:[0,1,10,13,15,16],runtim:12,safe:4,sake:16,same:[0,1,3,14,16],sampl:[1,14,16],sample_perc:1,sample_s:14,satisfi:1,satur:1,save:[2,3,4,5,6,7,8,14],save_model:16,savetxt:15,scalar:[0,1,3,4,13,16],scale:1,scenario:[2,3,4,5,6,7],schema:[1,16,17],scienc:17,scientist:13,score:1,screen:1,script:[0,2,3,4,5,6,7,8,13,15,17],script_build:[5,7,8,9],sds:[0,1,2,3,4,5,10,13,14,15,16],sds_context:[0,2,3,4,5,6,7],season:1,second:[1,2,4,15,16],see:[0,14],seed:[0,1,13,16],seen:[7,16],select:[1,16],self:0,selfeat:1,sent:0,separ:[0,16],seq:0,sequenc:[0,2,3,4,5,6,7,8],seri:1,serv:17,server:12,set:[1,2,3,4,5,6,7,13,14,15,16],setup:[14,15,16],sex:16,shape:[0,13,14],shear:1,shear_i:1,shear_x:1,shift:1,shortest:1,shortestpath:1,should:[0,1,2,3,4,5,6,7,8,9,12,13,15,16],show:16,showcas:16,shown:14,shuffl:1,side:[2,4],sigma:1,sigmoid:1,sim_se:1,similar:[1,12,13],simpl:[12,14],simpli:[7,14,15,16],simplic:14,simplifi:13,simul:[1,15],sin:[4,5],sinc:[0,1,3,13,14,16],singl:[0,1,14,15],sinh:[4,5],site:[0,7,16],size:[0,1,13,16],skip:[4,14,16],slice:[1,16],slicefind:1,slide:1,slightli:16,slow:1,small:16,smaller:14,smallest:[1,16],smooth:1,smote:1,solut:1,solv:1,solver:1,some:[13,14,15,16],someth:0,sort:[1,4],sourc:[0,1,16],sourcenod:1,space:1,spark:17,sparsiti:[0,13],speak:16,spec:16,specif:[7,14,16],specifi:[0,1,2,3,4,5,6,15,16],specificli:1,speed:16,split:[1,16],splitbalanc:1,squar:1,src:12,stablemarriag:1,stack:15,standard:[0,16],start:[0,1,13,14,16],start_steps:1,start_vicin:1,stat:1,statement:[0,1],statsna:1,statu:16,stderr:0,stdout:[0,1,7],step:[0,1,12],steplm:1,stepsiz:1,stop:[0,1,13,16],store:[1,7,8,16],str:[0,1,2,3,4,5,6,7,8,9,11],straightforward:16,strata:1,strategi:1,stratifi:1,strength:1,string:[1,2,3,4,5,6,7,8,9,11,16],sub:0,subprocess:[0,13],subregion:1,subsamp_r:1,subsequ:16,subset:[1,14],subtre:1,success:1,sum:[4,15],support:[0,1,15,16],suppos:[1,16],sure:12,surviv:1,survivor:1,symmetr:4,syntax:0,system:[12,17],systemd:[0,1,2,3,4,5,6,7,8,9,10,11,13,14,15,16],systemdscontext:[1,2,3,4,5,6,7,9,10,13,14,15,16],t_groups_o:1,take:[13,14,16],taken:0,tan:[4,5],tanh:[4,5],target:[1,16],task:[1,16,17],tau:1,tcp:0,techniqu:14,temp:15,tensor:[0,17],term:1,termin:[1,12,13,15],test:[1,14,15,16],test_count:16,test_data:16,test_label:16,test_typ:1,text:0,than:[1,2,3,4,5,6,7],thei:7,them:[0,16],therebi:7,therefor:[0,7,14],thi:[0,1,2,3,4,5,6,7,8,9,12,13,14,15,16,17],third:16,thorugh:0,those:16,thr:1,threashold:1,three:[12,14,15,16],threshold:[1,16],through:14,thrown:0,till:[1,2,3,4,5,6,7,8],time:[0,1,7,14],timestamp:1,to_one_hot:4,to_str:[4,5],todo:0,tol:1,toler:1,tolerang:1,tolobj:1,tolrecerr:1,tool:16,toonehot:1,top:[1,15,16],topmost:9,tpblksz:1,tpeval:1,trace:[2,3,4,5,6,7,8,9],trace_back_limit:0,train:[1,17],train_count:16,train_data:16,train_label:16,transfer:13,transform:[1,13,16],transform_appli:16,transform_encod:16,transpos:4,treat:16,tree:1,tripl:1,tsne:1,tupl:[0,7,9,15],tutori:14,two:[1,14,15,16],type:[0,1,2,3,4,5,6,7,8,14,16],uci:16,underli:17,undersampl:1,understand:16,unequ:1,unfortun:14,unifi:16,uniform:0,union:[0,1,2,3,4,5,7],uniqu:[0,1],unique_nam:0,univar:1,unknown:16,unlik:8,unlimit:1,unmodifi:1,unnam:[0,2,3,4,5,6,7,8,11],unnamed_input_nod:[2,3,4,5,6,7],unnamed_input_var:[2,3,4,5,6,7,8],unnamed_paramet:11,unnecessari:16,unord:1,unordr:1,unprocess:16,until:1,updat:1,upper:1,upward:14,usag:16,use:[1,2,3,4,5,6,8,9,10,11,12,13,14,15,16],used:[0,1,9,11,14,15,16],useful:[1,16],user:[1,17],userid:1,using:[0,3,6,12,13,14,15,16],usual:[1,14],util:[10,11],valid:[1,16],validation_split:1,valu:[0,1,2,3,4,5,6,7,8,13,14,16],valuabl:14,value_typ:16,var_nam:[2,3,4,5,6,7,8,9],variabl:[1,2,3,4,5,6,7,8,9,11,15],varianc:[1,4],varieti:14,varsmooth:1,vector:[0,1,14],verbos:[0,1,2,3,4,5,6,7,8,16],verifi:[12,14,16],versa:1,versatil:17,version:[12,16],vertex:1,vertic:1,via:12,vice:1,virtual:[2,3,4,5,7,8],visibl:1,vpow:1,vvv:1,wai:[2,3,4,5,6,14,16],walk:1,want:[1,14,16],wcss:1,week:16,weight:[1,16],well:[2,3,4,5,6,7,14,16,17],were:16,what:[14,16],wheel:12,when:[0,1,13,14],where:[1,14,16],whether:[1,16],which:[0,1,7,9,11,13,16],white:1,whole:[4,16],whose:[16,17],why:16,width:[1,16],win:1,window:1,window_s:1,winsor:1,wise:[2,4,13],within:16,without:[2,3,4,5,6,7,8],work:[14,15,16,17],workclass:16,worker:0,would:[0,1,16],write:[7,15],written:7,x_d:14,x_offset:1,x_train:1,x_val:1,xt_d:14,y_d:14,y_imp:1,y_offset:1,y_pred:[14,16],y_train:1,y_val:1,yet:[13,14,16],yhat:1,yield:16,yneg:1,you:[7,12,13,14,15,16],your:[0,12,15],yt_d:14,zero:[0,1,13]},titles:["SystemDSContext","Algorithms","Frame","List","Matrix","Scalar","Source","Operation Node","Dag","Script","Converters","Helpers","Install SystemDS","QuickStart","Built-in Algorithms","Federated Environment","Python end-to-end tutorial","SystemDS"],titleterms:{aggreg:15,algorithm:[1,14,16],appli:16,built:14,complex:13,confus:16,convert:10,dag:8,data:16,dataset:14,defin:16,end:16,environ:15,exampl:15,feder:15,format:14,frame:2,full:[14,16],get:14,helper:11,instal:12,level:16,list:3,load:16,matrix:[4,13,16],metadata:16,model:16,more:13,multipl:15,network:16,neural:16,node:7,obtain:16,oper:[7,13,16],pip:12,prepar:16,preprocess:16,python:16,quickstart:13,read:16,reshap:14,save:16,scalar:5,script:[9,14,16],simpl:15,sourc:[6,12],start:15,step:[14,16],systemd:[12,17],systemdscontext:0,train:[14,16],tune:14,tutori:16,valid:14,worker:15}})