# k8s安装MYSQL

启动命令

```sh
systemctl start etcd
systemctl start docker
systemctl start kube-apiserver
systemctl start kube-controller-manager
systemctl start kube-scheduler
systemctl start kubelet
systemctl start kube-proxy

```



rc文件

```yaml
apiVersion: v1
kind: ReplicationController   #副本控制器RC
metadata:
  name: mysql                 #RC的名称
spec:
  replicas: 1                 # POD副本期待数量
  selector:
    app: mysql                # 符合目标的pod拥有此标签
  template:                   # 根据此模板创建pod的副本
    metadata:
      labels:
        app: mysql            #pod有用的标签
    spec:
      containers:             #pod内容器的定义部分
        - name: mysql   #容器名称
          image: mysql  #容器对应的镜像
          ports:
            - containerPort: 3306
          env:  #容器的环境变量
            - name: MYSQL_ROOT_PASSWORD
              value: '123456'

```

`kubectl get pods 报 No resources found`

1. vi /etc/kubernetes/apiserver

2. 找到”KUBE_ADMISSION_CONTROL="--admission_control=NamespaceLifecycle,NamespaceExists,LimitRanger,SecurityContextDeny,ServiceAccount,ResourceQuota"

   去掉ServiceAccount，保存退出（按esc键，并输入":wq"或者":wq!"）。

3. systemctl restart kube-apiserver  重启此服务

` pod 一直处于ContainerCreating`

解决方法

1. `kubectl describe pod xxx`

2. "image pull failed for registry.access.redhat.com/rhel7/pod-infrastructure:latest, this may be because there are no credentials on this request.  details: (open /etc/docker/certs.d/registry.access.redhat.com/redhat-ca.crt: no such file or directory)"

3. ```
   yum install -y *rhsm*
   
   wget http://mirror.centos.org/centos/7/os/x86_64/Packages/python-rhsm-certificates-1.19.10-1.el7_4.x86_64.rpm
   
   rpm2cpio python-rhsm-certificates-1.19.10-1.el7_4.x86_64.rpm | cpio -iv --to-stdout ./etc/rhsm/ca/redhat-uep.pem | tee /etc/rhsm/ca/redhat-uep.pem
   ```

