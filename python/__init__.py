from flask import *
from flask_mysqldb import MySQL
from flask_cors import CORS, cross_origin
import MySQLdb
from MySQLdb import STRING as thwart
import os
import json
import time
import datetime
import requests
from time import gmtime, strftime

app = Flask(__name__, static_url_path='')
mysql = MySQL(app)

# MySQL configurations
app.config.from_pyfile('app.cfg')

@app.route('/')
@app.route('/home')
def dashboard():
    return "Halaman Utama"
#<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<PADI>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
@app.route('/padi/<int:id>', methods=["GET"])
def getPadiId(id):
    cnx = mysql.connection
    cur = cnx.cursor()
    query = "select * from padi where id = %s"
    eksekusi = cur.execute(query, (id, ))
    query_result = [ dict(line) for line in [zip([ column[0] for column in cur.description], row) for row in cur.fetchall()] ]
    data = jsonify(query_result)
    return data
    if eksekusi == False:
        return abort(404, "Data tidak ditemukan, mohon di periksa kembali id yang dimasukan",)
    else:
        return jsonify(data)

@app.route('/jagung/<int:id>', methods=["GET"])
def getJagungId(id):
    cnx = mysql.connection
    cur = cnx.cursor()
    query = "select * from jagung where id = %s"
    eksekusi = cur.execute(query, (id, ))
    query_result = [ dict(line) for line in [zip([ column[0] for column in cur.description], row) for row in cur.fetchall()] ]
    data = jsonify(query_result)
    return data
    if eksekusi == False:
        return abort(404, "Data tidak ditemukan, mohon di periksa kembali id yang dimasukan",)
    else:
        return jsonify(data)

@app.route('/gandum/<int:id>', methods=["GET"])
def getGandumId(id):
    cnx = mysql.connection
    cur = cnx.cursor()
    query = "select * from gandum where id = %s"
    eksekusi = cur.execute(query, (id, ))
    query_result = [ dict(line) for line in [zip([ column[0] for column in cur.description], row) for row in cur.fetchall()] ]
    data = jsonify(query_result)
    return data
    if eksekusi == False:
        return abort(404, "Data tidak ditemukan, mohon di periksa kembali id yang dimasukan",)
    else:
        return jsonify(data)

@app.route('/kentang/<int:id>', methods=["GET"])
def getKentangId(id):
    cnx = mysql.connection
    cur = cnx.cursor()
    query = "select * from kentang where id = %s"
    eksekusi = cur.execute(query, (id, ))
    query_result = [ dict(line) for line in [zip([ column[0] for column in cur.description], row) for row in cur.fetchall()] ]
    data = jsonify(query_result)
    return data
    if eksekusi == False:
        return abort(404, "Data tidak ditemukan, mohon di periksa kembali id yang dimasukan",)
    else:
        return jsonify(data)

@app.route('/singkong/<int:id>', methods=["GET"])
def getSingkongId(id):
    cnx = mysql.connection
    cur = cnx.cursor()
    query = "select * from singkong where id = %s"
    eksekusi = cur.execute(query, (id, ))
    query_result = [ dict(line) for line in [zip([ column[0] for column in cur.description], row) for row in cur.fetchall()] ]
    data = jsonify(query_result)
    return data
    if eksekusi == False:
        return abort(404, "Data tidak ditemukan, mohon di periksa kembali id yang dimasukan",)
    else:
        return jsonify(data)

@app.route('/tebu/<int:id>', methods=["GET"])
def getTebuId(id):
    cnx = mysql.connection
    cur = cnx.cursor()
    query = "select * from tebu where id = %s"
    eksekusi = cur.execute(query, (id, ))
    query_result = [ dict(line) for line in [zip([ column[0] for column in cur.description], row) for row in cur.fetchall()] ]
    data = jsonify(query_result)
    return data
    if eksekusi == False:
        return abort(404, "Data tidak ditemukan, mohon di periksa kembali id yang dimasukan",)
    else:
        return jsonify(data)

@app.route('/cobaan')
def cobaan():
    cur = mysql.connection.cursor()
    query = "select * from padi"
    cur.execute(query)
    data = cur.fetchall()
    return jsonify(data)

@app.route('/padi')
def getpadi():
    cnx = mysql.connection
    cur = cnx.cursor()
    query = "select * from padi"
    cur.execute(query)
    data = cur.fetchall()
    array = []
    content = {}
    for result in data:
       content ={'id': result[0],
                  'luas_lahan': result[1],
                  'tgl_tanam': result[2],
                  'tgl_siap_panen': result[3],
                  'hasil_panen': result[4],
                  'pemilik': result[5],
                  'nik': result[6],
                  'pekerja': result[7]
                }
       array.append(content)
    return jsonify(array)

#yang ditampilin cuma list tanpa key
#     query_result = [ dict(line) for line in [zip([ column[0] for column in cur.description], row) for row in cur.fetchall()] ]
#     data = jsonify(query_result)
#     return data
#yang ditampilin cuma 1 row aja
#     result = []
#     for row in data:
#         d= dict()
#         d['id'] = row[0]
#         d['luas lahan'] = row[1]
#         d['tgl_tanam'] = row[2]
#         d['tgl_siap_panen'] = row[3]
#         d['hasil_panen'] = row[4]
#         d['pemilik'] = row[5]
#         d['nik'] = row[6]
#         d['pekerja'] = row[7]
#         result.append(d)
#         return json.dumps(result, indent=8)
  
@app.route('/jagung')
def getjagung():
    cnx = mysql.connection
    cur = cnx.cursor()
    query = "select * from jagung"
    cur.execute(query)
    query_result = [ dict(line) for line in [zip([ column[0] for column in cur.description], row) for row in cur.fetchall()] ]
    data = jsonify(query_result)
    return data

@app.route('/kentang')
def getkentang():
    cnx = mysql.connection
    cur = cnx.cursor()
    query = "select * from kentang"
    cur.execute(query)
    query_result = [ dict(line) for line in [zip([ column[0] for column in cur.description], row) for row in cur.fetchall()] ]
    data = jsonify(query_result)
    return data

@app.route('/gandum')
def getgandum():
    cnx = mysql.connection
    cur = cnx.cursor()
    query = "select * from gandum"
    cur.execute(query)
    query_result = [ dict(line) for line in [zip([ column[0] for column in cur.description], row) for row in cur.fetchall()] ]
    data = jsonify(query_result)
    return data

@app.route('/singkong')
def getsingkong():
    cnx = mysql.connection
    cur = cnx.cursor()
    query = "select * from singkong"
    cur.execute(query)
    query_result = [ dict(line) for line in [zip([ column[0] for column in cur.description], row) for row in cur.fetchall()] ]
    data = jsonify(query_result)
    return data

@app.route('/tebu')
def gettebu():
    cnx = mysql.connection
    cur = cnx.cursor()
    query = "select * from tebu"
    cur.execute(query)
    query_result = [ dict(line) for line in [zip([ column[0] for column in cur.description], row) for row in cur.fetchall()] ]
    data = jsonify(query_result)
    return data


@app.route('/padi/input', methods =['POST'])
def input():
        cur = mysql.connection.cursor()
        luas_lahan = request.form['luas_lahan']
        tgl_tanam = request.form['tgl_tanam']
        tgl_siap_panen = request.form['tgl_siap_panen']
        hasil_panen = request.form['hasil_panen']
        pemilik = request.form['pemilik']
        nik = request.form['nik']
        pekerja = request.form['pekerja']
        query = "insert into padi(luas_lahan, tgl_tanam, tgl_siap_panen, hasil_panen, pemilik, nik, pekerja) VALUES( %s, %s, %s, %s, %s, %s, %s)"
        eksekusi = cur.execute (query,( luas_lahan, tgl_tanam, tgl_siap_panen, hasil_panen, pemilik, nik, pekerja))
        mysql.connection.commit()
        if query == False:
                ret = luas_lahan+ tgl_tanam+tgl_siap_panen+hasil_panen+pemilik+nik+pekerja
                return ret
                #return "gagal memasukan data"
        else:
                ret = luas_lahan+ tgl_tanam+tgl_siap_panen+hasil_panen+pemilik+nik+pekerja
                return ret
                #return redirect(url_for('getpadi'))

@app.route('/padi/update', methods = ['PUT'])
def update():
        cur = mysql.connection.cursor()
        padi_id         =       request.form['id']
        luas_lahan = request.form['luas_lahan']
        tgl_tanam = request.form['tgl_tanam']
        tgl_siap_panen = request.form['tgl_siap_panen']
        hasil_panen = request.form['hasil_panen']
        pemilik = request.form['pemilik']
        nik = request.form['nik']
        pekerja = request.form['pekerja']
        query = "UPDATE data_desa.padi SET luas_lahan = %s, tgl_tanam = %s, tgl_siap_panen = %s, hasil_panen = %s, pemilik = %s, nik = %s, pekerja = %s WHERE id = %s"
        eksekusi = cur.execute (query,(luas_lahan, tgl_tanam, tgl_siap_panen, hasil_panen, pemilik, nik, pekerja, padi_id))
        mysql.connection.commit()
        if eksekusi == False:
                return "gagal memasukan data"
        else:
                return redirect(url_for('getpadi'))


@app.route('/padi/delete', methods=["DELETE"])
def hapus():
    cur = mysql.connection.cursor()
    padi_id         =       request.form['id']
    try:
        eksekusi = cur.execute("DELETE FROM padi where id = %s", (padi_id, ))
        mysql.connection.commit()
        if eksekusi == False:
                return abort(404, "Data tidak ditemukan, mohon di periksa kembali id yang dimasukan",)
        else:
                return redirect(url_for('getpadi'))
    finally:
        cur.close()


if __name__ == '__main__':
    app.run(debug=True, host=app.config["HOST"])