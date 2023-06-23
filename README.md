# provision_mlops_aws
Provisioning MLOps platform in AWS solution


vpc:
  id: ${{ env.VPC_ID }}  # (optional, must match VPC ID used for each subnet below)
  cidr: "192.168.0.0/16"       # (optional, must match CIDR used by the given VPC)
  subnets:
    # must provide 'private' and/or 'public' subnets by availability zone as shown
    public:
      us-east-1d:
        id: "subnet-0b2512f8c6ae9bf30"
      us-east-1f:

managedNodeGroups:
  - name: ng-controlplane
    desiredCapacity: 2
    instanceType: r4g.small
    availabilityZones: ["us-east-1d", "us-east-1f"]
