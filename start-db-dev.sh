#!/bin/bash
export ENV_DATA="dev"
export MY_WORKSPACE="$(pwd)"
docker-compose -f docker-compose-local.yml run --service-ports postgres