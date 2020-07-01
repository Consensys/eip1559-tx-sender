## EIP-1559 tx sender

### Install
```shell script
./gradlew installDist
```
### Usage

#### Help
```shell script
./build/install/eip1559-tx-sender/bin/eip1559-tx-sender --help
```

```
Usage: tx-sender [-hV] [--eip-1559-tx-weight=<double>] [--num-threads=<int>]
                 [--num-transactions=<int>] [--repeat-every-n-seconds=<int>]
                 [--account-private-keys[=<privateKey[,<privateKey...]...]]...
                 [--rpc-endpoints[=<http://host:port>[,<http://host:
                 port>...]...]]...
Runs the tx-sender tool.
      --account-private-keys[=<privateKey[,<privateKey...]...]
                            Comma separated Ethereum account private keys.
      --eip-1559-tx-weight=<double>
                            Percentage of EIP-1559 transactions. (default: 0.5)
  -h, --help                Show this help message and exit.
      --num-threads=<int>   Number of threads. (default: 12)
      --num-transactions=<int>
                            Number of transactions sent for each account on
                              each RPC endpoint. (default: 10)
      --repeat-every-n-seconds=<int>
                            Repeat the process every n seconds, 0 means no
                              repeat. (default: 0)
      --rpc-endpoints[=<http://host:port>[,<http://host:port>...]...]
                            Comma separated RPC endpoints of Ethereum clients
                              nodes.
  -V, --version             Print version information and exit.
```
#### Sample

```shell script
./build/install/eip1559-tx-sender/bin/eip1559-tx-sender \
--rpc-endpoints=http://besu:8545,http://geth:8545 \
--account-private-keys=0xae6ae8e5ccbfb04590405997ee2d52d2b330726137b875053c36d94e974d162f \
--num-transactions=100 \
--eip-1559-tx-weight=0.32 \
--num-threads=8
```

