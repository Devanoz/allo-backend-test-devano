# Read Me First
Ini adalah project skeleton untuk backend test menggunakan Spring Boot.
Kandidat diharapkan untuk menambahkan kode diatas skeleton tersebut.

Dalam rangka menyambut Pemilu 2024 mari kita coba lebih mengenal lebih dekat para Calon Legislatif dengan membuat miniatur API untuk Caleg :)

Model/Entity yang sudah disiapkan:
- `Caleg`: Calon Legislatif
- `Partai`: Partai Pemilu
- `Dapil`: Daerah Pemilihan

# TODO
- Siapkan database script `.sql` dan letakkan di folder `resources/db`, boleh memilih database bebas
- Buat REST API untuk menampilkan list `Caleg`
    - Tambahkan filter cari berdasarkan `Dapil` dan `Partai`
    - Tambahkan sorting berdasarkan Nomor urut
- Buat Merge Request ke project ini

# Penilaian
- Kode yang dibuat adalah production ready
- Kode yang rapi dan mudah dimengerti
- Nilai tambah jika ditambahkan unit test

# How to Run
Docker compose
```shell
docker-compose up
```
application run on `http://localhost:8080`

# API Documentation
- GET /api/v1/calegs
    - Get caleg list
    - Query Param:
        - `page`: page index `0` range `0-n` starting from `0`
        - `size`: Total data for each page default `10`
        - `dapilId`: ID Dapil, default `null`
        - `partaiId`: ID Partai, default `null`
        - `partaiId`: ID Partai, default `null`
        - `sort`: Sort by `nomorUrut,asc` or `nomorUrut,desc` or `asc` or `desc` or `nomor_urut`
    - Response:
        ```json
        {
            "id": "2b2653a4-3f5f-4bfe-8550-252943a5687c",
            "dapil": {
                "id": "779e67e5-c9da-488c-b283-3d877a6fab2e",
                "nama_dapil": "Dapil 2",
                "provinsi": "Jawa Tengah",
                "wilayah_dapil_list": [
                    "Kabupaten Banjarnegara",
                    "Kabupaten Banyumas",
                    "Kabupaten Batang",
                    "Kabupaten Blora",
                    "Kabupaten Boyolali",
                    "Kabupaten Brebes",
                    "Kabupaten Cilacap",
                    "Kabupaten Demak",
                    "Kabupaten Grobogan",
                    "Kabupaten Jepara",
                    "Kabupaten Karanganyar",
                    "Kabupaten Kebumen"
                ],
                "jumlah_kursi": 11
            },
            "partai": {
                "id": "0a006219-e50c-4703-b579-ff05ac6c2797",
                "nama_partai": "Golkar",
                "nomor_urut": 3
            },
            "nomor_urut": 2,
            "nama": "Caleg 26",
            "jenis_kelamin": "PEREMPUAN"
        }
        ```
- GET /api/v1/calegs/{id}
    - Get caleg by id
    - Response:
        ```json
        {
            "id": "2b2653a4-3f5f-4bfe-8550-252943a5687c",
            "dapil": {
                "id": "779e67e5-c9da-488c-b283-3d877a6fab2e",
                "nama_dapil": "Dapil 2",
                "provinsi": "Jawa Tengah",
                "wilayah_dapil_list": [
                    "Kabupaten Banjarnegara",
                    "Kabupaten Banyumas",
                    "Kabupaten Batang",
                    "Kabupaten Blora",
                    "Kabupaten Boyolali",
                    "Kabupaten Brebes",
                    "Kabupaten Cilacap",
                    "Kabupaten Demak",
                    "Kabupaten Grobogan",
                    "Kabupaten Jepara",
                    "Kabupaten Karanganyar",
                    "Kabupaten Kebumen"
                ],
                "jumlah_kursi": 11
            },
            "partai": {
                "id": "0a006219-e50c-4703-b579-ff05ac6c2797",
                "nama_partai": "Golkar",
                "nomor_urut": 3
            },
            "nomor_urut": 2,
            "nama": "Caleg 26",
            "jenis_kelamin": "PEREMPUAN"
        }
        ```