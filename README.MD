## EIP-1559 chain filler

### Install
```shell script
./gradlew installDist
```
### Usage

#### Help
```shell script
./build/install/chain-filler/bin/chain-filler --help
```
![Help](./img/sample-help.png)
#### Samples

##### Internal fuzzing

```shell script
./build/install/chain-filler/bin/chain-filler \
--rpc-endpoints=http://besu:8545,http://geth:8545 \
--account-private-keys=0xae6ae8e5ccbfb04590405997ee2d52d2b330726137b875053c36d94e974d162f \
--recipient-addresses=0xfe3b557e8fb62b89f4916b721be55ceb828dbd73,0x627306090abaB3A6e1400e9345bC60c78a8BEf57
--num-transactions=100 \
--num-contracts=1 \
--eip-1559-tx-weight=0.75 \
--num-threads=8 \
--fuzz-transfer-value-lower-bound-eth=0.42 \
--fuzz-transfer-value-upper-bound-eth=8.67 \
--contract-dir=/etc/contracts
```

##### External fuzzing with NATS

```shell script
./build/install/chain-filler/bin/chain-filler \
--rpc-endpoints=http://127.0.0.1:8545 \
--account-private-keys=0xae6ae8e5ccbfb04590405997ee2d52d2b330726137b875053c36d94e974d162f,0xc87509a1c067bbde78beb793e6fa76530b6382a4c0241e5e4a9ec0a0f44dc0d3 \
--recipient-addresses=0xfe3b557e8fb62b89f4916b721be55ceb828dbd73,0x627306090abaB3A6e1400e9345bC60c78a8BEf57 \
--filler-mode=external_fuzzer_nats \
--nats-url=nats://127.0.0.1:4222 \
--nats-fuzzer-topic-transactions=fuzz.transactions
```

