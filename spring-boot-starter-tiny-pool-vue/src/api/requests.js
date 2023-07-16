import axios from "axios";

export function PoolList() {
    return axios.get("/api/tiny-pool/pool/");
}

export function PoolDetail(key) {
    return axios.get(`/api/tiny-pool/pool/${key}`);
}