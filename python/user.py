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
    return "INI HALAMAN UTAMA"
#<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<user>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
@app.route('/user/<int:id>', methods=["GET"])
def getId(id):
    cur = mysql.connection.cursor()
    query = "select * from orang where id = %s"
    eksekusi = cur.execute(query, (id, ))
    data = cur.fetchall()
    result = []
    for row in data:
        d= dict()
        d['id'] = row[0]
        d['name'] = row[1]
        d['country'] = row[2]
        d['city'] = row[3]
        result.append(d)
        return json.dumps(result, indent=4)
    if eksekusi == False:
        return abort(404, "Data tidak ditemukan, mohon di periksa kembali id yang dimasukan",)
    else:
        return jsonify(data)

@app.route('/user')
def getuser():
    cur = mysql.connection.cursor()
    query = "select * from orang"
    cur.execute(query)
    data = cur.fetchall()
    result = []
    for row in data:
        d= dict()
        d['id'] = row[0]
        d['name'] = row[1]
        d['country'] = row[2]
        d['city'] = row[3]
        result.append(d)
        return json.dumps(result, indent=4)

@app.route('/user/input', methods =['POST'])
def input():
        cur = mysql.connection.cursor()
        name = request.form['name']
        country = request.form['country']
        city = request.form['city']
        query = "insert into orang(name, country, city) VALUES( %s, %s, %s)"
        eksekusi = cur.execute (query,(name, country, city))
        mysql.connection.commit()
        if eksekusi == False:
                return "gagal memasukan data"
        else:
                return redirect(url_for('getuser'))

@app.route('/user/update/<int:id>', methods = ['PUT'])
def update(id):
        cur = mysql.connection.cursor()
        name = request.form['name']
        country = request.form['country']
        city = request.form['city']
        query = "UPDATE user.orang SET name = %s, country = %s, city = %s WHERE id = %s"
        eksekusi = cur.execute (query,(name, country, city, id))
        mysql.connection.commit()
        if eksekusi == False:
                return "gagal memasukan data"
        else:
                return redirect(url_for('getuser'))


@app.route('/user/hapus/<int:id>', methods=["GET"])
def hapus(id):
    cur = mysql.connection.cursor()
    try:
        eksekusi = cur.execute("DELETE FROM orang where id = %s", (id, ))
        mysql.connection.commit()
        if eksekusi == False:
                return abort(404, "Data tidak ditemukan, mohon di periksa kembali id yang dimasukan",)
        else:
                return redirect(url_for('getuser'))
    finally:
        cur.close()


if __name__ == '__main__':
    app.run(debug=True, host=app.config["HOST"],port=2000)